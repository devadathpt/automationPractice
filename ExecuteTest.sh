#!/bin/bash
mvn install test -Dcucumber.options="src/test/resources/feature/Addcart.feature --tags @Test"