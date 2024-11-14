./generate_jwtKeys.sh
chmod 644 ./jwt/privateKey.pem  
chmod 755 ./jwt                
cd amazon-cart
mvn clean compile package
cd ../amazon-jwt
mnv clean compile package
cd ../
docker compose up