# Assignment_5
Project Api_Calling : 

# 1- Dependancy : <br>
		1-Retrofit <br>
		2-JsonConvertor <br>
		3-Circular ImgView <br>
		4- Picaso //For Shoving IMG
		
   	implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.picasso:picasso:2.8")
			
# 2-  Create DataClass :
		Note - used PlugIn to Create DataClass 
		
# 3-  Create ApiInterface :
	example :
		@GET("endPoint")
		fun getProductData() : Call<MyData>

# 4- Create Object RetrofitBuilder in Main Activity.kt
	example :
		 val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
	
(IMP)	
# 5-  ** Store Data store karne**

		val retrofitData = retrofitBuilder.getProductData()
		
		retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                //Fetch Data From Api And Set Adapter
                   var responseBoday = response.body()
                  val userList= responseBoday?.users    // dataclass list

            // Set Adapter
	        myAdapter = MyAdapter(this@MainActivity,userList)
            recyclerView.adapter = myAdapter
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }
	    }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
               // If Data Not fetch Then Show or THrow Error
            }
  })
		
(IMP)	
# 6-  **Create Adapter Class **
	class MyAdapter(val context: Activity, val userList: List<User>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
	
	
	 override fun getItemCount(): Int {

        return userList.size

    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        //Create view holder If Adapter fail

        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

			//Set Recived Data into LayOut
			
        val currentItem =userList[position]
        holder.firstName.text =currentItem.firstName
        //set Image
        Picasso.get().load(currentItem.image).into(holder.image);

    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        //Create View (find elementId in layoutFile)

        val firstName: TextView
        val image: ImageView
		
        init {
            firstName = itemView.findViewById(R.id.firstName)
            image = itemView.findViewById(R.id.img_View)
        }
    }
