
			var lastId = '';
			var order_detail_page ='html/order/detail-order.html';
			var order_post_page = 'html/order/post-order.html';
			(function() {
				
				mui.init({
					//为了效率初始化加载 预加载
					preloadPages: [{
						id: order_detail_page,
						url: order_detail_page
					}],
					swipeBack: true, //启用右滑关闭功能
					pullRefresh: {
						container: '#list',
						down: {
							style: 'circle',
							offset: '0px',
							auto: true,
							callback: function() {
								//清空数据
								list.items=[];
								if(window.plus && plus.networkinfo.getCurrentType() === plus.networkinfo.CONNECTION_NONE) {
									plus.nativeUI.toast('似乎已断开与互联网的连接', {
										verticalAlign: 'top'
									});
									return;
								}

								var data = {
									column: 'orderid,promulgatorid,ordertime,ordercontent,rorderpicsrc,account,ordertheme,uiconsrc,orderstatus'
								}
//								if(lastId) { //说明已有数据，目前处于下拉刷新，增加时间戳，触发服务端立即刷新，返回最新数据
//									data.orderid = lastId;
//									data.ordertime = new Date().getTime() + "";
//								}
								//请求列表信息流
								
								mui.getJSON("http://39.108.159.175/phpworkplace/mui/order/getorder.php", data, function(rsp) {
								mui('#list').pullRefresh().endPulldown();
									if(rsp && rsp.length > 0) {
										lastId = rsp[0].orderid; //保存最新消息的id，方便下拉刷新时使用
										//拼接
										list.items = list.items.concat(convert(rsp));
										console.log("refreshing----converting data data-length:"+list.items.length);
									}
								});

							}
						}
					}
				});

				function convert(items) {
					var newItems = [];
					items.forEach(function(item) {
						newItems.push({
							orderid: item.orderid,
							promulgatorid: item.promulgatorid,
							ordertime: item.ordertime,
							ordercontent: item.ordercontent,
							orderpicsrc:item.rorderpicsrc,
							account:item.account,
							ordertheme:item.ordertheme,
							uiconsrc:item.uiconsrc,
							orderstatus:item.orderstatus
						});
					});
//					alert(newItems[0].orderid);
					return newItems;
				}

				mui('.mui-scroll-wrapper').scroll();
				mui('body').on('shown', '.mui-popover', function(e) {
					//console.log('shown', e.detail.id);//detail为当前popover元素
				});
				mui('body').on('hidden', '.mui-popover', function(e) {
					//console.log('hidden', e.detail.id);//detail为当前popover元素
				});

				//处理界面
				mui.plusReady(function() {
					//rewrite back function
					var backButtonPress = 0;
					mui.back = function(event) {
						backButtonPress++;
						if(backButtonPress > 1) {
							plus.runtime.quit();
						} else {
							plus.nativeUI.toast('再按一次退出应用');
						}
						setTimeout(function() {
							backButtonPress = 0;
						}, 1000);
						return false;
					};

//					mui.ajax('http://39.108.159.175/phpworkplace/mui/order/getorder.php', {
//						data: {
//							name: 123,
//							password: 123
//						},
//						dataType: 'json', //服务器返回json格式数据
//						type: 'POST', //HTTP请求类型
//						timeout: 5000, //超时时间设置为5秒；
//						//						headers: {
//						//							'Content-Type': 'application/json'
//						//						},
//						success: function(data) {
//							//服务器返回响应，根据响应结果，分析是否登录成功；
//							//														alert("服务器响应：succeed");
//							//														alert("data:"+data[0].ordercontent);
//						},
//						error: function(xhr, type, errorThrown) {
//							//异常处理；
//							alert("服务器繁忙");
//						}
//					});

					var self = plus.webview.currentWebview(),
						leftPos = Math.ceil((window.innerWidth - 60) / 2); // 设置凸起大图标为水平居中

					/**	
					 * 就是用来画那个圆形的点击还会变色的
					 * 其他的tab在manifest里面配置
					 * drawNativeIcon 绘制带边框的半圆，
					 * 实现原理：
					 *   id为bg的tag 创建带边框的圆
					 *   id为bg2的tag 创建白色矩形遮住圆下半部分，只显示凸起带边框部分
					 * 	 id为iconBg的红色背景图
					 *   id为icon的字体图标
					 *   注意创建先后顺序，创建越晚的层级越高
					 */
					var drawNativeIcon = util.drawNative('icon', {
						bottom: '5px',
						left: leftPos + 'px',
						width: '60px',
						height: '60px'
					}, [{
						tag: 'rect',
						id: 'bg',
						position: {
							top: '1px',
							left: '0px',
							width: '100%',
							height: '100%'
						},
						rectStyles: {
							color: '#fff',
							radius: '50%',
							borderColor: '#ccc',
							borderWidth: '1px'
						}
					}, {
						tag: 'rect',
						id: 'bg2',
						position: {
							bottom: '-0.5px',
							left: '0px',
							width: '100%',
							height: '45px'
						},
						rectStyles: {
							color: '#fff'
						}
					}, {
						tag: 'rect',
						id: 'iconBg',
						position: {
							top: '5px',
							left: '5px',
							width: '50px',
							height: '50px'
						},
						rectStyles: {
							color: '#d74b28',
							radius: '50%'
						}
					}, {
						tag: 'font',
						id: 'icon',
						text: '\uea0a', //此为字体图标Unicode码'\e600'转换为'\ue600'
						position: {
							top: '0px',
							left: '5px',
							width: '50px',
							height: '100%'
						},
						textStyles: {
							fontSrc: '_www/fonts/icomoon.ttf',
							align: 'center',
							color: '#fff',
							size: '30px'
						}
					}]);
					// append 到父webview中
					self.append(drawNativeIcon);

					//自定义监听图标点击事件
					var active_color = '#fff';
					drawNativeIcon.addEventListener('click', function(e) {
						//						mui.alert('以后增加的功能接口');
						backToIndex();
						mui('#bottomPopover').popover('toggle', document.getElementById("openBottomPopover"));
						//						alert("funn");
						//						var mask = mui.createMask();
						//						mask.show(); 
						// 重绘字体颜色
						if(active_color == '#fff') {
							drawNativeIcon.drawText('\uea0a', {}, {
								fontSrc: '_www/fonts/icomoon.ttf',
								align: 'center',
								color: '#000',
								size: '30px'
							}, 'icon');
							active_color = '#000';
						} else {
							drawNativeIcon.drawText('\uea0a', {}, {
								fontSrc: '_www/fonts/icomoon.ttf',
								align: 'center',
								color: '#fff',
								size: '30px'
							}, 'icon');
							active_color = '#fff';
						}

					});

					function backToIndex() {

						// 匹配对应tab窗口	
						targetPage = plus.webview.currentWebview();

						if(targetPage == activePage) {
							return;
						}
						//底部选项卡切换
						util.toggleNview(0);
						// 子页面切换
						util.changeSubpage(targetPage, activePage, aniShow);
						//更新当前活跃的页面
						activePage = targetPage;
					}
					// 中间凸起图标绘制及监听点击完毕

					// 创建子webview窗口 并初始化
					var aniShow = {};
					util.initSubpage(aniShow);

					var nview = plus.nativeObj.View.getViewById('tabBar'),
						activePage = plus.webview.currentWebview(),
						targetPage,
						subpages = util.options.subpages,
						pageW = window.innerWidth,
						currIndex = 0;

					/**
					 * 根据判断view控件点击位置判断切换的tab
					 */
					nview.addEventListener('click', function(e) {
						var clientX = e.clientX;
						if(clientX > 0 && clientX <= parseInt(pageW * 0.25)) {
							currIndex = 0;
						} else if(clientX > parseInt(pageW * 0.25) && clientX <= parseInt(pageW * 0.45)) {
							currIndex = 1;
						} else if(clientX > parseInt(pageW * 0.45) && clientX <= parseInt(pageW * 0.8)) {
							currIndex = 2;
						} else {
							currIndex = 3;
						}
						// 匹配对应tab窗口	
						if(currIndex > 0) {
							targetPage = plus.webview.getWebviewById(subpages[currIndex - 1]);
						} else {
							targetPage = plus.webview.currentWebview();
						}

						if(targetPage == activePage) {
							return;
						}
						//						console.log(targetPage.id+":"+activePage.id);
						//						if(currIndex !== 3) {
						//底部选项卡切换
						util.toggleNview(currIndex);
						// 子页面切换
						util.changeSubpage(targetPage, activePage, aniShow);
						//更新当前活跃的页面
						activePage = targetPage;
						//						} 
						//						else {
						//第四个tab 打开新窗口
						//							plus.webview.open('html/new-webview.html', 'new', {}, 'slide-in-right', 200);

						//						}
					});
					
//					backToIndex();
					
				});
			})();
			var list = new Vue({
									el: '#list',
									data: {
										items: []
									}
								});
			
			
			//listen*************************************************************************************
			//			var postorder = mui.preload({
			//					url:"html/order/post-order.html",
			//					id:"html/order/post-order.html",
			//			});
			document.getElementById("person-order").addEventListener("click", function() {
				var user = JSON.parse(localStorage.getItem('user'));
				if(user[0].loginstatus=='offline'){
					plus.nativeUI.toast("请先登陆");
					return;
				}
				var postorder = mui.preload({
					url: order_post_page,
					id: "html/order/post-order.html",
				});
				mui.fire(postorder, 'poster', {
					poster: 'person'
				});
				mui.openWindow({
					id: order_post_page
				});
				mui('#bottomPopover').popover('toggle', document.getElementById("openBottomPopover"));
			});
			document.getElementById('bussiness-order').addEventListener("click", function() {
				var user = JSON.parse(localStorage.getItem('user'));
				if(user[0].loginstatus=='offline'){
					plus.nativeUI.toast("请先登陆");
					return;
				}
				var postorder = mui.preload({
					url: order_post_page,
					id: order_post_page,
				});
				mui.fire(postorder, 'poster', {
					poster: 'bussiness'
				});
				mui.openWindow({
					id: order_post_page
				});
				mui('#bottomPopover').popover('toggle', document.getElementById("openBottomPopover"));
			});
		