# Graph
[![](https://jitpack.io/v/shashank1800/Graph.svg)](https://jitpack.io/#shashank1800/Graph)

### Step 1. 
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

### Step 2. 
Add the dependency

	dependencies {
	        implementation 'com.github.shashank1800:Graph:version'
	}
 
## How do I use Graph?

### Java

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		DrawGraph drawGraph = new DrawGraph();
		
		//add minimum 2 points
		drawGraph.addPoint(x1,y1);
		...
		
		BitmapDrawable drawable = drawGraph.drawGraph();
		ImageView imageView = (ImageView)findViewById(R.id.imageView);
		imageView.setBackground(drawable);
	}
		
### XML
	<ImageView
            android:id="@+id/imageView"
            android:layout_width="300dp"
            android:layout_height="300dp"
            android:orientation="vertical"/>

