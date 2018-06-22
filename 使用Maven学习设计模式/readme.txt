使用了vscode作为开发环境


工程配置：
	vscode:
		1、下载vscode+java的四个插件（含maven插件）
		2、配置java_home环境
		3、进入vscode，点击设置，再user setting 中找到java.home将示例配置修改一下到自己配置文件中
		4、可以在此配置可执行的maven目录，就不需要再配置maven的系统环境了
	maven：
		1、下载maven
		2、配置MAVEN_HOME和M2_HOME 两者一样都是maven的目录，添加到path 执行mvn -version测试是否完成配置
		3、可以配置本地仓库和镜像，再conf/setting.xml中配置
	
	启动maven工程：
		1、打开vscode 选择目录 右击目录 选择generate from maven archtype 选择quickstart
		2、启动工程，编译环境


错误：
	如果出现@override说明jdk版本高于1.5 不可写override

	运行后一闪而过：需要点击左上角的控制台图标切换为debug的输出

	待运行的文件需要再launch.json里面配置