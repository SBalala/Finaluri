package com.btu.finaluri.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.btu.finaluri.CarAdapter
import com.btu.finaluri.Cars
import com.btu.finaluri.R

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList : ArrayList<Cars>

    lateinit var id : Array<Int>
    lateinit var imageUrl : Array<String>
    lateinit var name : Array<String>
    lateinit var price : Array<String>
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        id = arrayOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            10,
            11,
            12,
            13
        )
        imageUrl = arrayOf(
            "https://www.carpixx.ch/wp-content/uploads/2021/09/1957_Ferrari_335_Sport_Scaglietti.jpg",
            "https://img.mensxp.com/media/content/2019/Sep/a-sneak-peek-at-messi-rsquo-s-garage4-1569328734.jpg",
            "https://i0.wp.com/21motoring.com/wp-content/uploads/2021/06/WhatsApp-Image-2021-06-08-at-4.17.55-PM.jpeg?resize=448%2C252&ssl=1",
            "https://s1.cdn.autoevolution.com/images/news/lionel-messis-maserati-granturismo-mc-stradale-offered-for-sale-looks-gaudy-114339_1.jpg",
            "https://i.pinimg.com/originals/bb/35/6e/bb356e54dd5e26306ae6edad84267b31.jpg",
            "https://gomechanic.in/blog/wp-content/uploads/2020/08/Lionel-Messi-Cars.jpg",
            "https://www.cartoq.com/wp-content/uploads/2018/06/Audi-A7-Messi_1.jpg",
            "https://pbs.twimg.com/media/Cv0k7-HVYAARduJ.jpg",
            "https://www.hellomonaco.com/wordpress/wp-content/uploads/2017/06/Audi-R8-V10.jpeg",
            "https://f7432d8eadcf865aa9d9-9c672a3a4ecaaacdf2fee3b3e6fd2716.ssl.cf3.rackcdn.com/C2299/U8092/IMG_30015-large.jpg",
            "https://gomechanic.in/blog/wp-content/uploads/2020/08/Land-Rover-Range-Rover-Sport.jpg",
            "https://i0.wp.com/tn.com.ar/resizer/VIFNkof99x0vduKA_Ufq2mg6Oak=/767x0/smart/filters:quality(60)/cloudfront-us-east-1.images.arcpublishing.com/artear/XILX3CAUGZCDHPJM7EILQQJI2M.jpg?w=800&ssl=1",
            "https://www.priorityauto.com/inventoryphotos/2493/2t2hgmda4nc078864/ip/1.jpg?height=400",


            )
        name = arrayOf(
            "Ferrari 335 S Spider Scaglietti",
            "Pagani Zonda Tricolore",
            "Mercedes SLS AMG",
            "Maserati Gran Turismo MC Stradale",
            "Ferrari F430 Spyder",
            "Audi RS6",
            "Audi A7",
            "Audi Q7",
            "Audi R7 Spyder",
            "Range Rover Vogue",
            "Range Rover Sport",
            "Cadillac Escalade",
            "Lexus RX 450h",
        )

        price = arrayOf(
            "$37 million",
            "$2 million",
            "$642,000",
            "$242,000",
            "$164,000",
            "$108,000",
            "$70,000",
            "$54,500",
            "$190,000",
            "$200,000",
            "$85,000",
            "$75,000",
            "$46,000"
        )

        newRecyclerView = view.findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager = LinearLayoutManager(activity)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Cars>()
        getUserdata()


    }

    private fun getUserdata() {

        for(i in id.indices){
            val mcars = Cars(id[i],imageUrl[i],name[i],price[i])
            newArrayList.add(mcars)

        }

        newRecyclerView.adapter = CarAdapter(newArrayList)

    }
}