<img width="1792" alt="Screenshot 2023-06-04 at 10 34 57 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5010be45-4771-426c-9de6-0c533dc2c340">

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
<img width="1792" alt="Screenshot 2023-05-16 at 1 27 01 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/67078d16-ff13-4961-8fd8-2ecae2bf1869">

```
Mutation
```

<img width="772" alt="Screenshot 2023-05-16 at 2 00 58 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/fae2e368-121e-498f-9174-a7a14ceb4b4f">
<img width="467" alt="Screenshot 2023-05-16 at 2 01 07 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/fd2cac72-42f5-4653-a287-0a02b47df656">
<img width="714" alt="Screenshot 2023-05-16 at 2 01 21 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5e9942ea-5e70-4840-8535-fcb8bf6b759a">
<img width="1792" alt="Screenshot 2023-05-16 at 2 35 52 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/991c3db8-c5f0-4700-96ac-39517f89d063">

```
File Upload
```

<img width="1792" alt="Screenshot 2023-06-01 at 1 18 59 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/55d0b70e-5f12-4575-8cb8-f83566556b7f">
<img width="1792" alt="Screenshot 2023-06-01 at 1 19 18 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/cff886c8-21f7-4bf9-ab7a-e7c2921059bf">
<img width="1789" alt="Screenshot 2023-06-01 at 1 19 40 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/25d0b27a-953b-4354-aea0-33406bcdee00">
<img width="1792" alt="Screenshot 2023-06-01 at 1 46 27 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/760c6b30-2731-4547-9ea6-f9610eb108c9">
<img width="1792" alt="Screenshot 2023-06-01 at 1 46 46 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/d2e7ff38-b40e-4607-8d4f-436b9b932502">

```
DataFetchingEnvironment
```

<img width="1792" alt="Screenshot 2023-06-03 at 6 11 41 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/77082568-5621-42ce-a530-a63cd095f99c">
<img width="1792" alt="Screenshot 2023-06-03 at 6 19 45 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/34deab61-8d44-498d-a7ca-b8b7f8e08603">
<img width="1792" alt="Screenshot 2023-06-03 at 6 21 59 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1ebf4e10-c4c6-4eed-8ff6-64b43cd03999">
<img width="1792" alt="Screenshot 2023-06-03 at 6 23 14 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/553fa653-6a47-4501-8158-4fbdc89a27f7">

```
Selection Set
```

```
A selection set is the set of fields the user requested. 

Having direct access to the fields can enable you to make performance optimized queries requesting only the needed data. For example an SQL backed system may be able to use the field sub selection to only retrieve the columns that have been asked for.

If you look ahead in the selection set, you may be able to optimize further and collapse two backend resource calls into one. For example, if you can retrieve the sellingLocations data within the products API call. You can group everything into one API query instead of two.

query {
        products {
            # the fields below represent the selection set
            name
            description
            sellingLocations {
                state
            }
        }
    }

The selection set (DataFetchingFieldSelectionSet) contains many useful utility methods such as:  contains, containsAnyOf, containsAnyOf. These can be used as the predicate to make your API call selection. 

To get the requested field names you can stream the fields, filter and collect into a set.
```

<img width="1792" alt="Screenshot 2023-06-03 at 6 41 08 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5714c9d5-6a62-4cd6-815e-92635efc3537">
<img width="1792" alt="Screenshot 2023-06-03 at 6 41 31 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/09b6e17c-1775-4505-9020-a5d51ce72075">

```
Scalars
```

```
A GraphQL scalar is a query leaf node that cannot be queried further via sub field selections. 
The graphql specification states that five standard scalars must always be present on the type system, these are: String, Int, Float, Boolean and ID.

It is very common that the standard five scalars are not descriptive enough. For example, how do we return a Date or DateTime? As a string? This is where we can create our own custom scalar implementations to define a more specific data type. 

Here, I introduce the java graphql extended scalars dependency (graphql-java-extended-scalars) which contains many out-of-the-box scalars for Date, DateTime, PositiveInt, NonNegativeInt and many many more. You can additionally create your own by creating an implementation of GraphQLScalarType and following the patterns from the extended scalars.


I just love the Numeric scalars:

PositiveInt
        An Int scalar that MUST be greater than zero.
NegativeInt
        An Int scalar that MUST be less than zero.
NonPositiveInt
        An Int scalar that MUST be less than or equal to zero.
NonNegativeInt
        An Int scalar that MUST be greater than or equal to zero.
PositiveFloat
        An Float scalar that MUST be greater than zero.
NegativeFloat
        An Float scalar that MUST be less than zero.
NonPositiveFloat
        An Float scalar that MUST be less than or equal to zero.
NonNegativeFloat
        An Float scalar that MUST be greater than or equal to zero.
```

<img width="1792" alt="Screenshot 2023-06-03 at 7 16 02 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/759722a7-766d-43b4-baa7-ae38ac5393aa">
<img width="1792" alt="Screenshot 2023-06-03 at 7 30 19 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/a23cdb58-02ea-4e68-bfec-fa653997c6c1">
<img width="1792" alt="Screenshot 2023-06-03 at 7 30 56 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/e52d70f0-a1ae-471b-8c85-d466a41b68d4">
<img width="1792" alt="Screenshot 2023-06-03 at 7 31 22 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/0d338eaf-462a-41d3-bcfd-9517bb73c303">
<img width="1792" alt="Screenshot 2023-06-03 at 7 33 06 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/72e09913-111d-47b6-9060-6e2dfac59e0c">
<img width="1792" alt="Screenshot 2023-06-03 at 7 34 52 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/26e6e404-dc6b-4aea-9dbe-d768c3a9cfd7">
<img width="1792" alt="Screenshot 2023-06-03 at 7 35 26 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5f155a66-73a1-4357-aac0-db8030cb26e3">

```
Data Type
```

<img width="1792" alt="Screenshot 2023-06-03 at 7 43 07 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1e261458-a6dd-41af-933d-9853beb6d75e">
<img width="1792" alt="Screenshot 2023-06-03 at 7 44 16 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/eb2b93cd-62df-416d-a041-32285a4d5298">
<img width="1792" alt="Screenshot 2023-06-03 at 7 45 08 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/e028a652-f356-426f-ad3c-de4eab846e0b">
<img width="1792" alt="Screenshot 2023-06-04 at 9 16 16 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1fa79adf-63b2-4c4a-8749-591a9e045fbf">
<img width="1792" alt="Screenshot 2023-06-04 at 9 18 03 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/e79c21da-9c55-417a-8b68-5b2b030c4a2d">
<img width="1792" alt="Screenshot 2023-06-04 at 9 19 13 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/e23591a9-dd09-487f-8ef5-0118d61a50a6">
<img width="1792" alt="Screenshot 2023-06-04 at 9 22 11 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/b578971e-77fa-4e41-9f15-a9f171015c00">

```
Input Validation

There are two ways of validating your graphql input types, via Directives or manually validating the input type in your resolver. In this episode we focus on the more old-school approach and put the JSR-303 bean validation annotations on our pojos. In a following tutorial, we will look at graphql-java-extended-validation which will allow us to remove all java bean validation annotations, and instead place the annotations directly on the schema. Pretty cool. 

As graphql-java-extended-validation is still under active development and first stable release was 2 days ago (17 September 2020) I will provide tutorials on both validation methods . 
```

<img width="1792" alt="Screenshot 2023-06-04 at 10 09 07 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/cf89f989-f2b7-47cb-aabd-8c3099797f5a">
<img width="1792" alt="Screenshot 2023-06-04 at 10 10 46 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/089fd781-207a-4453-95c5-297d1dfb8b7d">
<img width="1792" alt="Screenshot 2023-06-04 at 10 11 13 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/cf2fa2f4-cabc-4d0a-89b7-21c797fb7f08">
<img width="1792" alt="Screenshot 2023-06-04 at 10 12 58 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ad7e2586-ac82-414a-9a47-e0f1cad89d4e">
<img width="1792" alt="Screenshot 2023-06-04 at 10 13 29 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/f6a444e3-ae4f-4071-a736-508489041fcc">
<img width="1792" alt="Screenshot 2023-06-04 at 10 14 46 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1374f4ac-a7cf-48c2-9310-bdbb551a3096">
<img width="1792" alt="Screenshot 2023-06-04 at 10 17 10 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/cd8088fe-0302-46c4-8588-f31120e12183">


```
Listener

The GraphQL Servlet library allows you to add a Servlet Listener for listening to the GraphQL request. It provides hooks into the servlet request execution (request, success, error, and finally).

The Servlet Listener listens to the servlet request, but not to the GraphQL query execution. If you want to listen to that (pre/post resolver methods etc) you should use the Instrumentation provided by GraphQL Java.
```

<img width="1792" alt="Screenshot 2023-06-04 at 10 29 04 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/3d036a26-d60f-4581-bd77-08f0e65884f6">
<img width="1792" alt="Screenshot 2023-06-04 at 10 30 41 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/dd667bc8-a65b-4c37-b9f8-c8badcc83bef">

```
Pagination (Edges, Nodes, Cursor)

GraphQL Spring Boot supports the recommended relay connection cursor pagination pattern.

In this video, I implement the relay @connection directive and create a matching resolver with the graphql java relay Connection, Edges, Nodes, 
PageInfo, StartCursor, EndCursor, isHasPreviousPage, isHasNextPage and Cursor package / classes.

I have found that cursor-based pagination is the most powerful pagination pattern so-far. 

Especially if the graphql cursors are opaque, and the real cursor value is used in combination with the SEEK sql pattern (or equivalent in other data stores). 
Making the graphql cursor opaque (base 64 encoded) provides the additional flexibility if the pagination model changes in the future. 
For example, the graphql api customers  / UI only needs to change the input filters and can consistently use the cursor to offset the next pages. 
The UI does not need to know about the cursors real value, which parameter to set it in and in which format. It just supplies the edge's cursor to the 'after'. So... what I'm getting at is... the UI can stay simple :) 
```

<img width="833" alt="Screenshot 2023-06-04 at 10 42 11 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/58d8dfdc-eb90-4473-a606-28a3b8fc5bec">
<img width="1792" alt="Screenshot 2023-06-04 at 10 43 09 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/90594763-680f-4b0f-99b3-59445d382103">
<img width="1792" alt="Screenshot 2023-06-04 at 10 47 55 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/9c0e316e-2884-4457-93c1-0015767847ff">
<img width="870" alt="Screenshot 2023-06-04 at 10 48 29 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/89b384e7-4724-4aa6-a8d3-9b15e9a557c8">

https://relay.dev/graphql/connections.htm

<img width="1792" alt="Screenshot 2023-06-04 at 11 27 08 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ffbebadd-a33f-45ef-a487-4fa4b9d889f3">
<img width="1792" alt="Screenshot 2023-06-04 at 11 36 26 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1cf43178-6299-4662-be6b-dd439c9a4aff">
<img width="1792" alt="Screenshot 2023-06-04 at 11 40 26 AM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/b69bedea-c0bc-40a1-af34-2bc5c5fbcd84">
<img width="1792" alt="Screenshot 2023-06-04 at 12 00 05 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/6551ca66-3f66-4947-a040-854183bd599b">
<img width="1792" alt="Screenshot 2023-06-04 at 12 00 33 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/d91d9e69-b9ce-4bc7-9769-39ddbbac9e5d">
<img width="1792" alt="Screenshot 2023-06-04 at 12 01 42 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/32bd2316-6d24-4e18-af0c-ec73b9377ea8">
<img width="1792" alt="Screenshot 2023-06-04 at 12 03 24 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/159ed88f-1aa2-49f7-afe5-bc0b524ea6a1">
<img width="1792" alt="Screenshot 2023-06-04 at 12 12 50 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/d8d34667-1ae9-4d4a-81b0-a587b1758c1c">
<img width="1792" alt="Screenshot 2023-06-04 at 12 13 13 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/1c8a899b-53e1-4321-95de-e6c46bac763b">
<img width="1792" alt="Screenshot 2023-06-04 at 12 13 31 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ea13decc-b059-412c-bdf6-96c47b33748f">
<img width="1792" alt="Screenshot 2023-06-04 at 12 13 45 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/b130fd06-c4ec-4389-9d4f-0922b3cdce19">
<img width="1792" alt="Screenshot 2023-06-04 at 12 13 58 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/2f4b01ce-9530-480c-9cbd-ddec8bd4b8ef">

```
Custom Context


In graphql spring boot, you have the ability to create a custom object once at the very start of the query/mutation, and this object will be available
to all mutations and queries via the DataFetchingEnvironment. The custom object can be any type, and is never used by the internal graphql java framework.


As the context is created once and available in all revolvers; a common use-case to store user authorization data such as user id, permissions 
and roles. This data can then be used to perform authorization on your mutation and resolvers. An alternative to this is spring security and
pass the security context to other threads via DelegatingSecurityContextExecutorService. But the context file can contain anything you wish.

```

<img width="1792" alt="Screenshot 2023-06-04 at 2 37 22 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/7926349e-3322-4d72-b3a5-865fadc4127f">
<img width="1792" alt="Screenshot 2023-06-04 at 2 37 42 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/77a62f05-9551-469e-9bc7-f7508213a0b6">
<img width="1792" alt="Screenshot 2023-06-04 at 2 37 58 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/f03f28ff-a1fb-4da1-a19c-be0163612df7">
<img width="1792" alt="Screenshot 2023-06-04 at 2 38 12 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/a9040104-9565-4255-b931-10b5f4a405aa">

```
Data Loader

The dreaded graphql N+1 problem gives most devs the creeps. 

By default in GraphQL, a query resolver will resolve a field's nodes sequentially. When you have a list (see connection cursor video linked below) of nodes, It will resolve each node's fields sequentially. For example if you have 2 nodes with field X  in the selection set. It will execute the query resolver first, then resolver for Node1 Field X followed by Node2 Field X. This is the N+1 problem. 


I simulate how a small backend API latency can introduce massive latency into your graphql API. That is with dataloader neglect.


In most cases you would want to group together Field X values and batch them to the backing API. This leads to massive performance gains in reduction of network traffic and optimal database queries on the datasource. 

Here we use the Java graphql dataloader (a direct port of facebook's dataloader) to solve this problem. We can easily use CompletableFutures to load the IDs and I recommend using  a mapped batch dataloader. With the DataLoader creation you can customize the cache and maximum batch size with the DataLoaderOptions parameter.


Often there is not a 1:1 mapping of your batch loaded keys to the values returned.
For example, a SQL query may return fewer results than query IDs. (does not exist or duplicates).
If you would use the classic dataloader, then the values would be returned into the wrong requesting nodes and the last (Requested Ids minus responded ids) would have null values. This is because it mays 1:1 by default. Big trouble here.


To get around this, we can return a map from the dataloader function. When the map is processed by the DataLoader code, any keys that are missing in the map will be replaced with null values. The semantic that the number of DataLoader.load requests are matched with an equal number of values is kept.

The keys provided MUST be first class keys since they will be used to examine the returned map and create the list of results, with nulls filling in for missing values.

Single Network Call For Every Single Node, Latency Of First Request Will Be Added To The Second Request And So On.
```

<img width="1792" alt="Screenshot 2023-06-04 at 4 24 40 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/c23a7d75-a172-42bf-aeda-39eef2c3907e">
<img width="1787" alt="Screenshot 2023-06-04 at 4 25 08 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/aff50db0-de4b-4000-a49b-318de318d50f">
<img width="1792" alt="Screenshot 2023-06-04 at 5 02 42 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/e8e6255b-336d-484b-b2ed-f3aa1d6dbb96">
<img width="1792" alt="Screenshot 2023-06-04 at 5 03 05 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ed4d7cbe-4bfb-488d-b161-192e44e59031">
<img width="1787" alt="Screenshot 2023-06-04 at 5 13 33 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/4f4b0d13-bbaa-4d25-a438-f47fd3f2604e">
<img width="1792" alt="Screenshot 2023-06-04 at 5 13 44 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/f28df6fb-9ba4-411c-84f7-181cef3f90ec">
<img width="1792" alt="Screenshot 2023-06-04 at 5 13 58 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/ac70f52b-ef72-4915-96c4-4e4fef089b54">
<img width="1792" alt="Screenshot 2023-06-04 at 5 14 04 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/dc51a515-11b6-4736-a261-ed170f80ef43">
<img width="1792" alt="Screenshot 2023-06-04 at 5 14 17 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/dfe4851a-5b03-460d-ae11-f5b7ee9b7ab6">


```
Instrumentation (Request Logging)
```

<img width="1792" alt="Screenshot 2023-06-04 at 3 42 32 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/92a0a4df-9478-44fd-abae-66ee81e5dd98">
<img width="1792" alt="Screenshot 2023-06-04 at 3 42 57 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/a1600eb3-5ec4-4741-9b67-fe831f2183fd">

```
Request Tracing
```

<img width="1792" alt="Screenshot 2023-06-04 at 3 15 40 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/38d1b099-f1e2-4891-9cb0-44e748b24a86">
<img width="1792" alt="Screenshot 2023-06-04 at 3 50 39 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/02d57909-e5f9-442f-a50e-528be5e4c6a9">
<img width="1792" alt="Screenshot 2023-06-04 at 3 50 51 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/5a33ffc4-810d-449c-a76b-2c9ed1121f3e">
<img width="1792" alt="Screenshot 2023-06-04 at 3 51 18 PM" src="https://github.com/SaiAshish9/SpringBoot_GraphQL/assets/43849911/0a35dbec-5ffc-46fc-ac27-f0d02d610c66">

https://netflix.github.io/dgs/advanced/instrumentation/

```
Correlation ID (Thread propagation)
```


