An authorization server based on Spring boot 2.0.0M4, OAuth2, Mongo DB and JWT token.
This project also uses lombok to remove boilerplate code.

#Steps to run
1. Generate a JWT token keystore:-
	
	keytool -genkeypair -alias jwt -keyalg RSA -dname "CN=jwt, L=Delhi, S=NewDelhi, C=India" -keypass mySecretKey -keystore jwt.jks -storepass mySecretKey
	
	**It will create a jwt.jks file which must be placed in application src/main/resources folder** 
	
2. 	Then execute 


	keytool -list -rfc --keystore jwt.jks | openssl x509 -inform pem -pubkey

3. Copy the public key (including the dashed lines) into a file named “public.cert”.
This file will be used by resource servers.

4. Create a mongodb database with name - "scopeweaver" or you can change this name is application.properties

5. Add a user with username and password in a collection with name "users" in your mongo database.

6. Compile and deploy the application

7. Test your application by hitting 
	
	curl -XPOST "web_app:@localhost:9999/oauth/token" -d "grant_type=password&username=admin&password=password"

	It should return the generated token.

