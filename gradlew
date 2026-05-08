#!/bin/bash
set -e
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64
GRADLE_VERSION=8.9
GRADLE_DIR=$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}
if [ ! -f "$GRADLE_DIR/bin/gradle" ]; then
  mkdir -p "$GRADLE_DIR"
  echo "Downloading Gradle $GRADLE_VERSION..."
  curl -sL "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o /tmp/gradle.zip
  unzip -qo /tmp/gradle.zip -d "$GRADLE_DIR"
  mv "$GRADLE_DIR/gradle-${GRADLE_VERSION}"/* "$GRADLE_DIR/"
  rm -rf "$GRADLE_DIR/gradle-${GRADLE_VERSION}"
  rm -f /tmp/gradle.zip
  echo "Gradle downloaded"
fi
export PATH=$GRADLE_DIR/bin:$PATH
exec gradle "$@"
