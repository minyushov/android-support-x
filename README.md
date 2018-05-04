### Setting up the dependency
```groovy
repositories {
  maven {
    url  "http://dl.bintray.com/minyushov/android" 
  }
}
```
```groovy
dependencies {
  implementation 'com.minyushov.android.support:support-compat-x:version'
  implementation 'com.minyushov.android.support:recyclerview-x:version'
  implementation 'com.minyushov.android.support:appcompat-x:version'
}
```

Please replace `version` with the latest version: [![Download](https://api.bintray.com/packages/minyushov/android/appcompat-x/images/download.svg)](https://bintray.com/minyushov/android/appcompat-x/_latestVersion)