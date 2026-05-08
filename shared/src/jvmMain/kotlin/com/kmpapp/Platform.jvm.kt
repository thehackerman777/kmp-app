package com.kmpapp

actual fun getPlatformName(): String = "JVM ${System.getProperty("java.version")}"
