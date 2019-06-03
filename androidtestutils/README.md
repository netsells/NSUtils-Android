# Android Test Utils

This module exposes a number of dependencies for testing purposes:

* JUnit
* Mockito
* AndroidX Test
* Room test helpers
* Android Architecture components test helpers
* Espresso
* Robolectric Annotations
* Koin Test

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
