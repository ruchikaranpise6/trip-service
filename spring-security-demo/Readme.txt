1. Create User on Keycloak
2. Create token using given end point(Security Controller), username and password to generate token.

It will go in userDetailsServiceImpl, load the userByUsernmae and mapp it to userDetailImpl. Will be using DAOAuthenticationProvider

3. jwtService.generateToken -> will create jwtService class, in will have createToken method will will generate token based on claims, subject, and signing alogo SignatureAlgorithm.HS256,
will also have validate token method here in this class.

4. JWTAuthFilter extends OncePerRequestFilter -> this is the filter to validate the token passed to access api is valite or not
Password encoder -> BCryptPasswordEncoder