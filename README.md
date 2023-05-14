<img width="1792" alt="Screenshot 2023-05-13 at 1 07 43 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ef735dce-3e02-49ec-ba52-7a1dd3b7d355">

<img width="1792" alt="Screenshot 2023-05-13 at 1 08 15 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/0381f50b-502f-4e79-a24a-7362915858d8">

<img width="1792" alt="Screenshot 2023-05-13 at 1 08 27 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/2092b30d-fb4c-4d98-b70a-30f3919cc1f8">

```
Recursion In GraphQL:
```

<img width="734" alt="Screenshot 2023-05-13 at 3 28 40 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/bf769f6c-c9f1-4f66-bd37-7b476068cc4a">

<img width="256" alt="Screenshot 2023-05-13 at 3 29 18 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/9d32a03f-9074-4f6e-967a-8320a2ad5d85">

<img width="372" alt="Screenshot 2023-05-13 at 3 29 40 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/534bc341-8562-4c82-a44f-fcbdad9faf9d">

<img width="1792" alt="Screenshot 2023-05-13 at 3 33 43 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/add80156-2750-42b6-bb85-eefec4f8c624">

```
MaxQueryDepth
```

<img width="620" alt="Screenshot 2023-05-13 at 3 41 32 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/95261f7c-f4a2-4b8e-b29d-534f966b2617">

<img width="734" alt="Screenshot 2023-05-13 at 3 49 10 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/415cb5af-4a55-48de-9e14-466ccaecfe79">

<img width="500" alt="Screenshot 2023-05-13 at 4 02 25 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/2bebd62a-2848-4c03-8d8d-08b62c5271b4">

```
Recursion in a graphql schema is possible. This presents some denial-of-service vulnerabilities in our graphql server. Why? 

If two types have reference to each other, you have now exposed a cyclical query:

type A {
    b: B
}

type B {
   a: A
}

An attacker could exploit this and submit an extremely large query containing A - B - A - B - A - B etc. Depending how your server resolves these elements, will have different side effects. Your graphql server could make thousands of extra network requests, perform expensive CPU operations, bring down your server with out-of-memory error or saturate all tomcat request threads, denying other users access to the graphql server. 

There are various ways to mitigate this vulnerability, one simple way is by using a GraphQL query max depth limit. Requests will be rejected that request a query depth exceeding the limit. This can be specified in graphql spring boot with the property:

graphql.servlet.maxQueryDepth
```

```
Playground Variables
```

<img width="1792" alt="Screenshot 2023-05-14 at 6 38 39 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/123a4844-af9f-404d-badc-25c9db7b9ab0">

<img width="1791" alt="Screenshot 2023-05-14 at 6 39 39 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/964fe7ed-adfe-45f2-aea8-eb8e405a6f06">

<img width="929" alt="Screenshot 2023-05-14 at 6 42 10 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/f6f9e22c-ea39-4906-af67-c67fdce2fbfe">

```

```



