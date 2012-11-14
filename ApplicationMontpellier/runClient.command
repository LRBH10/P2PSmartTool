#!/bin/bash
cd $( cd "$( dirname "$0") " && pwd )
java -jar org.eclipse.osgi_3.6.2.R36x_v20110210.jar -console -clean -configuration config-client
