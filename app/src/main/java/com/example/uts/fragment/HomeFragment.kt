package com.example.uts.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uts.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"




class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: SuperheroAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var superheroArrayList : ArrayList<Superhero>

    lateinit var image : Array<Int>
    lateinit var name : Array<String>
    lateinit var description: Array<String>
    lateinit var rate : Array<String>
    lateinit var news : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_hero)
        recyclerView.layoutManager  = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter

        superheroArrayList = arrayListOf<Superhero>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in image.indices) {

            val superhero = Superhero(image[i], name[i], description[i], rate[i])
            superheroArrayList.add(superhero)
        }

        var adapter = SuperheroAdapter(superheroArrayList)
        recyclerView.adapter = adapter
        adapter.setOnItemClikListener(object : SuperheroAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                // Toast.makeText(requireActivity(), "You Clicked on Item no. $position", Toast.LENGTH_SHORT).show()

                val intent = Intent(requireActivity(),DetailSuperheroActivity::class.java)
                intent.putExtra("image", superheroArrayList[position].imgSuperhero)
                intent.putExtra("name", superheroArrayList[position].nameSuperhero)
                intent.putExtra("news",news[position])
                startActivity(intent)


            }

        })
    }

    private fun dataInitialize(){
        superheroArrayList = arrayListOf<Superhero>()

        image = arrayOf(
            R.drawable.law,
            R.drawable.yor,
            R.drawable.itachii,
            R.drawable.giyu,
            R.drawable.norrman,
            R.drawable.akame,
            R.drawable.kamado,
            R.drawable.nar,
            R.drawable.nezuko,
            R.drawable.killuua,
            R.drawable.gara4,
            R.drawable.conann,
            R.drawable.gon,
        )

        name = arrayOf(
            "L. Lawliet",
            "Tsugikuni Yoriichi",
            "Uchiha Itachi",
            "Tomioka Giyu",
            "Norman",
            "Akame",
            "Kamado Tanjiro",
            "Uzumaki Naruto",
            "Kamado Nezuko",
            "Killua Zoldyck",
            "gaara",
            "Edogawa Conan",
            "Gon Freecss"
        )

        description = arrayOf(
            "Death Note",
            "Demon Slayer",
            "Naruto: Shippuden",
            "Demon Slayer",
            "The Promised Neverland",
            "Akame ga Kill!",
            "Demon Slayer",
            "Naruto: Shippuden",
            "Demon Slayer",
            "Hunter x Hunter",
            "Naruto: Shippuden",
            "Detectif Conan",
            "Hunter x Hunter"

        )

        rate = arrayOf(
            "10/10",
            "10/10",
            "10/10",
            "9/10",
            "10/10",
            "9/10",
            "10/10",
            "10/10",
            "9.5/10",
            "10/10",
            "9.5/10",
            "10/10",
            "10/10",
        )

        news = arrayOf(
            "L. Lawliet adalah karakter fiksi dalam seri manga Death Note. Dia adalah seorang genius eksentrik dan detektif swasta yang punya reputasi sebagai detektif terbaik di dunia. L mampu mengungkapkan fakta bahwa Light adalah seorang Kira.",
            "Yoriichi juga dikenal sebagai Demon Slayer terkuat yang pernah ada, sekaligus yang menciptakan Teknik Pernapasan. Dia menjadi orang pertama yang menciptakan Teknik Pernapasan pertama yang pada akhirnya menjadi Hinokami Kagura yang digunakan oleh Tanjiro Kamado dan keluarga Kamado.",
            "Itachi Uchiha adalah karakter fiksi dalam serial manga dan anime Naruto. Ia merupakan kakak kandung dari Sasuke Uchiha dan seorang mantan ketua Anbu Konohagakure dari Klan Uchiha. Ia bertanggung jawab atas peristiwa Pembantaian Klan Uchiha yang telah membuatnya menjadi seorang ninja buronan tingkat S.",
            "Giyuu Tomioka merupakan Hashira, elite prajurit Korps Pembasmi Iblis, yang tak membunuh Nezuko padahal ia merupakan iblis. Giyuu Tomioka adalah sosok Hashira yang pertama kali dimunculkan oleh Demon Slayer Kimetsu no Yaiba.",
            "Norman merupakan salah satu karakter utama The Promised Neverland bersama dengan Ray dan Emma. Norman adalah anak ajaib genius matematika dan murid teladan Grace Field House. Ia punya kecerdasan yang melampaui rekan-rekannya, bahkan orang dewasa.",
            "Akame adalah anggota Night Raid, sebelum bergabung dengan Night Raid, dia adalah anggota pasukan khusus di kerajaan. Akame termasuk kedalam karakter yang kuat, dengan pedangnya yang bernama Murasame serta gerakannya yang lincah, dia bisa membuat lawannya mati dalam sekali tebasan pedang.",
            "Protagonis dari  anime Demon Slayer ini bernama Kamado Tanjiro. Ia adalah salah satu dari anggota korps bawah tanah Pembasmi Iblis. Sebelum menjadi pembasmi iblis, Tanjiro bekerja sebagai penjual arang untuk mencari nafkah. Dia mencoba untuk mencari obat yang bisa menyembuhkan adiknya yang berubah menjadi iblis agar bisa kembali menjadi manusia lagi. Demi mewujudkannya Dia memutuskan untuk menjadi pembunuh iblis.",
            "Naruto Uzumaki yang bergelar Hokage Ketujuh adalah tokoh utama dari serial anime dan manga Naruto. Ia merupakan tokoh utama dalam serial ini. Ia digambarkan sebagai bocah berambut pirang dan bermata biru. Di pipinya ada semacam guratan yang mirip seperti kumis milik karakter Doraemon dalam manga Doraemon.",
            "Nezuko Kamado adalah iblis dalam seri Demon Slayer. Dia secara paksa diubah menjadi iblis oleh Muzan, raja iblis. Tapi dia masih memiliki kesadaran sebagai manusia, dia tidak dapat berbicara dan harus memakai sumbat bambu agar tidak menggigit siapa pun. Tidak seperti iblis yang memakan daging manusia, Nezuko mendapatkan kembali energi dari tidur dan cenderung menjadi tidak sadar untuk waktu yang lama setelah terlalu memaksakan diri.",
            "Killua Zoldick awalnya diperkenalkan sebagai karakter yang mirip dengan Gon. Dia juga merupakan salah satu karakter yang paling cepat dalam berpikir dan teman baik Gon. Namun seiring perjalanan ceritanya, Killua mengalami pengembangan karakter yang tak terbayangkan",
            "Gaara merupakan anak bungsu Kazekage Keempat dan adik Temari dan Kankurou. Gaara pernah berperan sebagai karakter jahat sepanjang awal kemunculannya sehingga babak ujian chunin. Dibesarkan sebagai suatu senjata khas untuk mempertahankan desanya, dia diberi gelar Sabaku no Gaara. dan seiiring perjalanan ceritanya dia menjadi kazekage kelima di naruto shippuden",
            "Edogawa Conan menjadi karakter utama setelah Kudo Shinichi mengonsumsi racun dan membuat tubuhnya mengecil. Nama Edogawa Conan dipilih sebagai penyamaran identitas aslinya karena ia harus melanjutkan profesinya menjadi detektif dan membantu sang ayah. Conan juga mempunyai misi penting dalam memecahkan misteri Organisasi Hitam karena perbuatannya telah mengubah tubuh Shinichi.",
            "Gon Freecss adalah karakter utama sekaligus protagonis da;am anime Hunter x Hunter. Gon memiliki keingnan untuk menjadi Hunter dan menemukan ayahnya. Gon dibekali kekuatan dam kemampuan memulihkan diri yang hebat, Hatsu nya disebut Jajanken yang terdiri dari tiga bagian, yaitu batu, kertas, dan gunting.",
        )

    }
}