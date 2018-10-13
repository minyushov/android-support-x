### Setting up the dependency
```groovy
repositories {
  maven {
    url  "http://dl.bintray.com/minyushov/androidx"
  }
}
```
```groovy
dependencies {
  implementation 'androidx.ext:core:version'
  implementation 'androidx.ext:recyclerview:version'
  implementation 'androidx.ext:appcompat:version'
}
```

Please replace `version` with the latest version: [![Download](https://api.bintray.com/packages/minyushov/androidx/core/images/download.svg)](https://bintray.com/minyushov/androidx/core/_latestVersion)