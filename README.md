# AutoFitView-for-text

## this library is the lightest AutoFitText in the world and very fast

Resize text and fit with bounds,
you can use anywhere any api,
if you have problem, tell me.

--------------------------------------

**1. copy,paste `AutoFitView.java` in your project and set package insted "com.app"**

**2. add these codes in values/attrs.xml:**
```xml

<declare-styleable name="auto_fit_view">
        <attr name="autofit_text" format="string"/>
</declare-styleable>

```

**3. use in layout:**
```xml

<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:app="http://schemas.android.com/apk/res-auto"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent">

	<com.yourapp.AutoFitView
	       android:id="@+id/autoFitTextView"
  	       android:layout_width="0dp"
    	       android:layout_height="wrap_content"
	       app:autofit_text="200181280064548"
	       app:layout_constraintStart_toStartOf="parent"
	       app:layout_constraintEnd_toEndOf="parent"
	       app:layout_constraintTop_toTopOf="parent" />
       
</android.support.constraint.ConstraintLayout>

```
