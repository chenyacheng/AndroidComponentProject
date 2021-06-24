## 目录
- [介绍](#介绍)

- [项目编译](#项目编译)

- [结语](#结语)

### 介绍：

为了避免项目发展到一定阶段，出现代码臃肿、耦合度高、开发效率低等一些问题，项目采用组件化AndroidMVP+Retrofit2+Rxjava2+AutoDispose+ARouter等组合架构搭建，项目已经迁移到JetPack中的AndroidX。后端接口数据使用[https://www.easy-mock.com](#https://www.easy-mock.com)

### 项目编译

 使用`AndroidStudio 3.2`或更高版本进行编译

### 使用
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.chenyacheng:AndroidComponentProject:1.2'
	}
