# Android Notification : 
A notification is a message that Android displays outside your app's UI to provide the user with reminders,
communication from other people, or other timely information from your app.
Users can tap the notification to open your app or take an action directly from the notification. <br>

# Documentation : (https://developer.android.com/develop/ui/views/notifications)
			
# 1-> For Creating a Notification You Need To Create This Variable first 

Var CHANNEL_ID="CHANNEL_ID"
Var CHANNEL_NAME="CHANNEL_NAME"
Var NOTIFICATION_ID = 0 
 
# 2-> Create Notification Channel Function 

Fun createNotificationChannel () {

if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){

Val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT)
.apply{
description="THisismynotificationCHannel"
lightColor=Color.CYAN
enableLights(true)
}

Val manager = getSystemService(Context.NOTIFICATION_SERVICE)asNotificationManager
 manager.createNotificationChannel(channel)
}
}
 

# 3-> Call  Notification Channel Function In On Create Function

 
# 4-> Create Notification According to You 

Val notification = NotificationCompat.Builder(this,CHANNEL_ID)
	.setContentTitle("30DaysOfAppDevChallenge")
	.setContentText("Congratulation")
	.setSmallIcon(R.drawable.self)
	.setPriority(NotificationCompat.PRIORITY_HIGH)
	.build()

# 5-> Now notificationManager And Show Notification According to You 

Val notificationManager = NotificationManagerCompat.from(this)
	notificationManager.notify(NOTIFICATION_ID,notification)
		
*************************************************************************

#   * Pending Intent *

	1-> 	val intent = Intent(this , MainActivity::class.java)
	     val pendingintent = PendingIntent.getActivity(this,0,intent,PendingIntent.FlagMutable)

	2-> Call this in Notification
	
			.setContentIntent(pendingintent)
	
*************************************************************************
