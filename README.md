# NSUtils (Android)

[![Build Status](https://travis-ci.com/netsells/NSUtils-Android.svg?token=DiqKJJ5WUURHNCgsBBXw&branch=master)](https://travis-ci.com/netsells/NSUtils-Android)
[![Release](https://jitpack.io/v/netsells/nsutils-android.svg)](https://jitpack.io/#netsells/nsutils-android)

A collection of commonly used functions for Android projects.

## Installation

```groovy
dependencies {
  implementation 'com.github.netsells.nsutils-android:nsutils:0.4.3'
  testImplementation 'com.github.netsells.nsutils-android:testutils:0.4.3'
  androidTestImplementation 'com.github.netsells.nsutils-android:androidtestutils:0.4.3'
}
```

## About

NSUtils-Android contains 3 modules:

* `nsutils`, which includes some handy functions for general development
* [`testutils`](testutils/README.md), which includes all the testing dependencies you could ever need plus a couple of helpers
* [`androidtestutils`](androidtestutils/README.md), as above but for on-device tests
