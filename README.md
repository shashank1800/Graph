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
		DrawGraph drawGraph = new DrawGraph(context);
		
		//add min 2 points
		drawGraph.addPoint(x1,y1);
		drawGraph.addPoint(x2,y2);
		
		BitmapDrawable drawable = drawGraph.drawGraph();
		LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);
		linearLayout.setBackground(drawable);
		
		//set Co-ordinate color
		drawGraph.setCoordinateColor(Color.RED);
		
		//set line color
		drawGraph.setLineColor(Color.GREEN);
	}
		
### XML
	<LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"/>

