### 目录结构
```
├─ META-INF
│   ├─ MANIFEST.MF
├─ org
│   └─ springframework
│       └─ boot
│          └─ loader
│              ├─ ExecutableArchiveLauncher.class
│              ├─ JarLauncher.class
│              ├─ JavaAgentDetector.class
│              ├─ LaunchedURLClassLoader.class
│              ├─ Launcher.class
│              ├─ MainMethodRunner.class
│              ├─ ...                
├─ WEB-INF
│   └─ classes
│       ├─ com
│       ├─ public
│       ├─ static
│       ├─ templates
│       ├─ application.yml
│       └─ banner.txt
├─ lib
│   ├── classmate-1.3.3.jar
│   ├── spring-boot-starter-1.5.2.RELEASE.jar
│   ├── spring-beans-4.3.7.RELEASE.jar
│   ├── ...
└─ 
```

### MANIFEST.MF
```
Manifest-Version: 1.0
Implementation-Title: spring-boot-example
Implementation-Version: 0.0.1-SNAPSHOT
Archiver-Version: Plexus Archiver
Built-By: Administrator
Implementation-Vendor-Id: yyl
Spring-Boot-Version: 1.5.2.RELEASE
Implementation-Vendor: Pivotal Software, Inc.
Main-Class: org.springframework.boot.loader.WarLauncher
Start-Class: yyl.spring.boot.Application
Spring-Boot-Classes: WEB-INF/classes/
Spring-Boot-Lib: WEB-INF/lib/
Created-By: Apache Maven 3.3.3
Build-Jdk: 1.8.0_74
```
其中 Main-Class是 org.springframework.boot.loader.WarLauncher ,这个是war启动的Main函数
如果打的是jar包，则是 org.springframework.boot.loader.JarLauncher