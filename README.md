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
GraphQL Voyager
```

<img width="658" alt="Screenshot 2023-05-15 at 1 36 57 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5efa7a8b-0961-491f-b012-89271adb0a0e">

<img width="1789" alt="Screenshot 2023-05-15 at 1 37 59 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/6fb4e79a-50fc-475d-b8a7-b8198ffac757">

```
Resolvers
```

<img width="1792" alt="Screenshot 2023-05-15 at 11 27 19 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/c261ff2e-7525-44db-a20d-36be7afc7327">

<img width="654" alt="Screenshot 2023-05-15 at 11 27 38 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5e418d44-7890-4a5d-b28f-638dbab711ef">

<img width="747" alt="Screenshot 2023-05-15 at 11 27 55 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/e58c1aa8-9a17-426d-b4bd-03a93eeef114">


<img width="580" alt="Screenshot 2023-05-15 at 11 28 19 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1ca46d56-ba8b-4c68-8dd2-766bcc1459fe">

```
Exception Handling with ExceptionHandler
```

<img width="837" alt="Screenshot 2023-05-15 at 11 38 32 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/0892a689-729f-4eda-add1-34109160a399">

<img width="1792" alt="Screenshot 2023-05-15 at 11 39 44 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/2602d0ee-4b6f-4ed2-b4a9-b6242be13c29">


```
GraphqlExceptionHandler
```

<img width="636" alt="Screenshot 2023-05-16 at 12 01 03 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5d3e7ec1-b4c3-4ecb-a0d4-071ccf14014f">

<img width="730" alt="Screenshot 2023-05-16 at 12 01 25 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/62631228-b04d-4a0b-bc56-3dbcaef24e65">

<img width="678" alt="Screenshot 2023-05-16 at 12 01 50 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/d3b8ea90-ff37-49a8-a871-b44d634a87c5">

<img width="729" alt="Screenshot 2023-05-16 at 12 03 20 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/6b8855c7-d36b-4555-b2a0-4056d207bdf2">

<img width="1516" alt="Screenshot 2023-05-16 at 12 04 33 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/a41282ec-651c-42b2-b34b-853a8fad418e">

<img width="1527" alt="Screenshot 2023-05-16 at 12 05 51 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/d0b29d5e-3e42-4857-a0d1-98fa501e23bc">

<img width="1792" alt="Screenshot 2023-05-16 at 12 06 21 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ff214fb0-e5f8-4f52-9050-e11026de3c3d">

<img width="1211" alt="Screenshot 2023-05-16 at 12 14 17 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/9aa0db2f-02e3-4d5e-a4ee-01b76d9a1525">

<img width="1778" alt="Screenshot 2023-05-16 at 12 14 45 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/b6142ad8-e397-4a3b-8c87-030f418ef420">

<img width="1671" alt="Screenshot 2023-05-16 at 12 15 13 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5c342e2e-7fac-4ebb-9683-45b4cbcb221d">


```
DataFetcherResult
```

<img width="878" alt="Screenshot 2023-05-16 at 12 38 03 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/61c84aef-5fd9-4f12-a88d-d28ed181f0d3">

<img width="1792" alt="Screenshot 2023-05-16 at 12 38 32 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/55dba8fa-933d-4f6f-8ac9-d87dd8580fec">

```
Asynchronous Resolvers

assets resolver will wait until the client resolver is completed
```

<img width="1792" alt="Screenshot 2023-05-16 at 1 24 43 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/46df81fd-2a3e-4e12-a55a-02ba39c96257">

<img width="1792" alt="Screenshot 2023-05-16 at 1 24 55 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ac8ed45f-13bc-4dc0-a71a-7901f8d2e1a4">
