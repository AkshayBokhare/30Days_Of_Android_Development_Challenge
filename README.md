# Fragment:
A Fragment represents a reusable portion of your app's UI. <br>
 A fragment defines and manages its own layout, has its own lifecycle,<br>
 and can handle its own input events. Fragments can't live on their own. <br>
 They must be hosted by an activity or another fragment.<br>
 The fragment’s view hierarchy becomes part of, or attaches to, the host’s view hierarchy.
 
# Fragment Life Cycle <br> :<br>
(https://github.com/NTS-AkshayBokhare/30Days_Of_Android_Development_Challenge/assets/138112705/bcf8e4d8-d612-4566-b573-29b0a0acf5b0)

## How To Create Fragment:

1-> Create One Function 

	private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction =fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout , fragment)
        fragmentTransaction.commit()
    }
	
## 2->     Call This Function in main Function -> replaceWithFragment(fragmentname())

     
	bottomView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.home -> replaceWithFragment(HomeFragment())
                R.id.search -> replaceWithFragment(SearchFragment())
                R.id.profile -> replaceWithFragment(ProfileFragment())
                else -> {

                }
            }
            true
        }
