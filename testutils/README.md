# Test Utils

This module exposes a number of useful testing APIs including: 
* JUnit
* Hamcrest
* Mockito
* Android Architecture Core testing libraries
* Coroutines test helpers
* Robolectric
* Espresso
* Google Truth
* AndroidX Test
* Koin Testing

## `DataBindingIdlingResource`

Included is a `DataBindingIdlingResource` which can be used for Robolectric simulated tests. Essentially it allows you to wait for data binding to complete before continuing a test:

```kotlin
class MyTest {

  private val dataBindingIdlingResource = DataBindingIdlingResource()
  
  @Before
  fun registerIdlingResource() {
      IdlingRegistry.getInstance().register(dataBindingIdlingResource)
  }
  
  @After
  fun unregisterIdlingResource() {
      IdlingRegistry.getInstance().unregister(dataBindingIdlingResource)
  }
  
  
  @Test
  fun test() {
    val scenario = ActivityScenario.launch(MainActivity::class.java)

    dataBindingIdlingResource.monitorActivity(scenario)
    
    // Continue the test
  }
  
}
```
