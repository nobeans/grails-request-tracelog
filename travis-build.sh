#!/bin/bash
set -e

./gradlew clean check assemble

if [ -z $TRAVIS_BRANCH ]; then
    echo "ERROR: must run on travis" >&2
    exit 1
fi

echo "TRAVIS_TAG: $TRAVIS_TAG"
echo "TRAVIS_BRANCH: $TRAVIS_BRANCH"
if [ -z $TRAVIS_TAG ]; then
    exit 0
fi

echo "Publishing archives to bintray..."

exit_status=0
./gradlew bintrayUpload || exit_status=$?
if [ $exit_status -ne 0 ]; then
    echo "ERROR: could not publish to bintray: $exit_status" >&2
    exit $exit_status
fi

echo "Published."
