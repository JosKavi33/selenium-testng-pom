#!/bin/bash
echo "Running test suite and generating Allure Report..."
./mvnw clean test -Dgroups=regression -Dbrowser="chrome" -Dheadless
./mvnw allure:report
