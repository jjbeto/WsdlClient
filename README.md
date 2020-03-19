# WsdlClient

Small WSDL client using Vanila SpringBoot.

## How to test

The app runs on default SpringBoot port (8080) and listen to the root "/" endpoint, which just return the result of the WSDL call directly to browser.

## Key notes
1. The app uses an object to request data (for this example just a user/pass wrapper);
2. The WSDL uses WSDL 1.1 Action feature, which must be added to the HTTP header during the call;
