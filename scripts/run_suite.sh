#!/bin/bash
echo "Starting the test run..."
./mvnw clean test -Dgroups=regression -Dbrowser="chrome" -Dheadless
echo "Tests completed."