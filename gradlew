#!/bin/bash
set -e
# Use JAVA_HOME if set, otherwise try common paths
if [ -z "$JAVA_HOME" ]; then
  for dir in /usr/lib/jvm/java-21-openjdk-amd64 /usr/lib/jvm/java-21-openjdk-arm64 /opt/hostedtoolcache/Java_Temurin-Hotspot_jdk/21*/x64; do
    if [ -f "$dir/bin/java" ]; then
      export JAVA_HOME="$dir"
      break
    fi
  done
fi
if [ ! -f "$JAVA_HOME/bin/java" ]; then
  echo "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME"
  echo "Please set the JAVA_HOME variable in your environment to match the"
  echo "location of your Java installation."
  exit 1
fi
export JAVA_HOME
GRADLE_VERSION=8.9
GRADLE_DIR=$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}
if [ ! -f "$GRADLE_DIR/bin/gradle" ]; then
  mkdir -p "$GRADLE_DIR"
  echo "Downloading Gradle $GRADLE_VERSION..."
  curl -sL "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o /tmp/gradle.zip
  unzip -qo /tmp/gradle.zip -d "$GRADLE_DIR"
  if [ -d "$GRADLE_DIR/gradle-${GRADLE_VERSION}" ]; then
    mv "$GRADLE_DIR/gradle-${GRADLE_VERSION}"/* "$GRADLE_DIR/"
    rm -rf "$GRADLE_DIR/gradle-${GRADLE_VERSION}"
  fi
  rm -f /tmp/gradle.zip
  echo "Gradle downloaded"
fi
export PATH=$GRADLE_DIR/bin:$PATH
exec gradle "$@"
