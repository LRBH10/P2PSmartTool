#!/bin/bash
java -Dosgi.bundles=openchord@1:start -Dinria.smarttools.dht.port=1501 -jar org.eclipse.osgi_3.6.2.R36x_v20110210.jar -clean -console
