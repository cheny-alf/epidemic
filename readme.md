项目描述

   该系统利用java爬虫技术，实现了模仿腾讯新闻中实时疫情情况页的数据可视化。首先从网络上获取数据，对数据进行处理，然后利用Echarts将数据可视化。并且利用Spring-Security来快速的解决权限问题。

功能总结

      实时数据的获取：

             利用Jsoup解析html格式数据，或者从资源信息网页中获取数据。利用cron表达式进行定时更新信息，满足数据的实时化。每次发送请求，将信息重新写入数据库中进行更新，然后在重新获取。

      展示数据：

              利用Echarts制作图表，来对后端传递过来的信息进行展示。在本项目中，绘制了曲线图、条形图、中国地图等。可以很清晰的将数据信息展示给人们。

      国际化i18n：

              该功能实现了将网页中的中文和英文对转换，能够快速的将网页转换成英文版或者其他语言。同时，自定义LocaleResolver类也实现了自定义切换语种的功能。

      权限登录功能：

              利用Spring-security实现针对不同的用户，赋予不同的权限，然后跳转不同的页面。

项目地址：https://github.com/cheny-alf/epidemic
![Image text](https://github.com/cheny-alf/epidemic/blob/master/trend.png)
