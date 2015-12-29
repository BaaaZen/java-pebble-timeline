# java-pebble-timeline

This is a Java library for the Pebble Timeline API. Documentation for the full api can be found [here](https://developer.getpebble.com/guides/timeline/). 

### Usage

```
Pin pin = new Pin.Builder().id("example-pin-generic-1")
				.time(new Date())
				.layout(new GenericPin.Builder()
						.title("News at 6 o'clock")
						.tinyIcon(Icon.NOTIFICATION_FLAG)
						.build())
				.build();
				
Timeline.sendPin("my-token", pin);
```

See [tests](src/test/java/nl/palolem/timeline) for more examples. 