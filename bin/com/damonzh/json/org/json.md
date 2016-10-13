
## 1、简介
org.json是Java常用的Json解析工具，主要提供JSONObject和JSONArray类，现在就各个类的使用解释如下。 

## 2、准备
1.在使用org.json之前，我们应该先从该网址https://github.com/douglascrockford/JSON-java下载org.json源码，并将源码其加入到Eclipse中，即可调用。 
2.查看相关的API文档，访问：https://github.com/douglascrockford/JSON-java。 

### 3、讲解
#### JSONObject： 
> 是一个无序的键/值对集合。 
> 它的表现形式是一个包裹在花括号的字符串，键和值之间使用冒号隔开，键值和键值之间使用逗号隔开。 
> 内在形式是一个使用get()和opt()方法通过键来访问值，和使用put()方法通过键来添加或者替代值的对象。 
> 值可以是任何这些类型：Boolean,JSONArray,JSONObject,Number和String，或者JOSONObject.NULL对象。 

注：JSONObject有很多optXXX方法，比如optBoolean, optString, optInt... 
他们的意思是，如果这个jsonObject有这个属性，则返回这个属性，否则返回一个默认值。 

#### JSONArray
> 是一个有序的序列值。 
> 它的表现形式是一个包裹在方括号的字符串，值和值之间使用逗号隔开。 
> 内在形式是一个使用get()和opt()方法通过索引来访问值，和使用put()方法来添加或修改值的对象。 
> 值可以是任何这些类型：Boolean,JSONArray,JSONObject,Number,和String，或者JSONObject.NULL对象。 

#### JSONStringer
> 是一个用于快速构造JSON文本的工具 
> JSONWriter的子类 
> bject():开始一个对象，即添加{；enObject():结束一个对象，即添加} 
> array():开始一个数组，即添加[； endArray():结束一个数组，即添加] 
> key():表示添加一个key；value():表示添加一个value 

#### JSONTokener
> 它和JSONObject和JSONArray的构造函数一起使用，用于解析JSON源字符串 
