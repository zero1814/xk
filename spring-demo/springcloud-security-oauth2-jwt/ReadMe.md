test-jwt.jks的生成,test123为密码，test-jwt.jks放在认证服务器

keytool -genkeypair -alias test-jwt -validity 3650 -keyalg RSA -dname "CN=jwt,OU=jtw,O=jtw,L=zurich,S=zurich,C=CH" -keypass test123 -keystore test-jwt.jks -storepass test123

JWT的解密需要公钥
keytool -list -rfc --keystore test-jwt.jks | openssl x509 -inform pem -pubkey
