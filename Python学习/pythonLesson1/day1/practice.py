#!/bin/python
# coding=utf-8
import os,time


'''要求 输入用户密码
		成功则显示信息
		失败三次锁定 30s
'''

while 1:
  name = raw_input("请输入用户名:").strip()
  if len(name)==0:
    print '\033[31;1m Username cannot be empty!\033[0m'
    continue
  pwd = raw_input("请输入密码:").strip()
  if len(pwd)==0:
    print '\033[31;1m password cannot be empty!\033[0m'
    continue
  '''验证逻辑'''
   
  '''读取本地用户文件'''
  try:
    file =open('userConf','r+')
  except IOError:
    print 'no user config file' 
    break


  '''用户名处理'''
  line = file.readline()
  '''读取第一行 解析name=知道最后的字符'''
  fName = line[5:]

  '''密码处理'''
  line = file.readline()
  '''读取第一行 解析pwd=知道最后的字符'''
  fPwd = line[4:]

  '''锁定处理'''
  line = file.readline()
  '''读取第一行 解析locaked=知道最后的字符'''
  fLocked = line[8:]

  '''获取尝试次数 超过三次需要加锁'''
  line = file.readline()
  tryTimes = int(line[9:]) 
  if tryTimes>3:
    '''加锁并且清空tryTimes'''

  file.close()

  '''登陆逻辑'''

  '''锁定下判断时间戳  如果超过30秒可以登陆''' 
  statinfo = os.stat('userConf')
  interval = time.time()-statinfo.st_mtime

  if name!=fName.strip() or pwd!=fPwd.strip():
    print '用户名或密码错误'
    '''需要增加尝试次数后写入文件'''
    tryTimes++;

  elif int(fLocked)==1 and interval<30:
      print '用户已经被锁定'

  else:
    print '你好 %s 欢迎登陆' %name
  
  break
	
  

