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
            R.drawable.ivana,
            R.drawable.itttt,
            R.drawable.evil,
            R.drawable.conjuring,
            R.drawable.gonjiam,
            R.drawable.megan,
            R.drawable.nun,
            R.drawable.qorin,
            R.drawable.ratu,
            R.drawable.tall,
            R.drawable.two,
        )

        name = arrayOf(
            "Ivana",
            "IT",
            "Evil Dead Rise",
            "The Conjuring III",
            "Gonjiam Hospital Maldito",
            "Megan",
            "The Nun",
            "Qorin",
            "Ratu Ilmu Hitam",
            "In The Tall Grass",
            "A Tale Of Two Sisters",
        )

        description = arrayOf(
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",
            "Horor",


        )

        rate = arrayOf(
            "8/10",
            "9/10",
            "10/10",
            "9/10",
            "9.5/10",
            "9/10",
            "10/10",
            "10/10",
            "9.5/10",
            "10/10",
            "9.5/10",
            "9/10",
            "8/10",
        )

        news = arrayOf(
            "Ambar dan keluarganya diteror saat merayakan Lebaran di kawasan Bandung. Ambar, seorang wanita muda cantik yang memiliki keterbatasan penglihatan, mampu melihat hal-hal yang tidak bisa dilihat orang lain.",
            "Tujuh pemuda buangan di Derry, Maine, akan menghadapi mimpi terburuk mereka -- kejahatan kuno yang berubah bentuk yang muncul dari selokan setiap 27 tahun untuk memangsa anak-anak kota. Bersatu selama satu musim panas yang mengerikan, teman-teman harus mengatasi ketakutan pribadi mereka sendiri untuk melawan badut pembunuh haus darah yang dikenal sebagai Pennywise..",
            "Evil Dead Rise menceritakan kisah mengejutkan tentang dua saudara perempuan yang terasing yang reuninya dipersingkat oleh munculnya setan yang merasuki manusia, mendorong mereka ke dalam pertempuran utama untuk bertahan hidup saat mereka menghadapi versi keluarga paling mengerikan yang bisa dibayangkan.",
            "Kisah mengerikan tentang teror, Pembunuhan, dan kejahatan yang tak diketahui kisah sebelumnya yang mengejutkan bahkan dialami oleh keluarga Ed dan Lorraine Warren. Salah satu kasus paling sensasional dari arsip penyelidikan mereka, dimulai dengan pertarungan untuk jiwa seorang anak laki-laki, kemudian saya mbawa mereka ke seuatu yang belum pernah mereka lihat dan alami sebelumnya,",
            "Para awak web seri horor pergi ke sebuah gedung tua bekas rumah sakit jiwa untuk melakukan pengambilan gambar dan segera bertemu dengan hal-hal supranatural yang menjadi mimpi buruk bagi mereka",
            "Seorang insinyur robotika di sebuah perusahaan mainan membuat boneka yang penampilannya seperti gadis kecil dan diprogram agar menjadi teman sekaligus penjaga bagi anak-anak. Sampai petaka dimulai saat boneka M3gan ternyata mulai hidup dan meneror penciptanya.",
            "Ketika seorang biarawati muda di sebuah biara terpencil di Rumania mengambil nyawanya sendiri, seorang pendeta dengan masa lalu yang kelam dan seorang novisiat di ambang sumpah terakhirnya dikirim oleh Vatikan untuk menyelidikinya. Bersama-sama, mereka mengungkap rahasia ordo yang tidak suci itu. Mempertaruhkan tidak hanya hidup mereka tetapi juga iman dan jiwa mereka, mereka menghadapi kekuatan jahat dalam bentuk biarawati setan.",
            "Satu persatu penghuni asrama putri kerasukan. Zahra dan Yolanda berusaha mengungkap keganjilan yang terjadi pada teman-teman mereka, sampai pada satu malam, semua Jin Qorin penghuni asrama putri bangkit mengancam nyawa.",
            "Hanif membawa Nadya istrinya dan ketiga anak mereka ke panti asuhan tempat Hanif dulu dibesarkan. Pengasuh panti itu, Pak Bandi, sudah sangat tua dan sakit keras, Hanif datang untuk menjenguk setelah bertahun-tahun tidak bertemu. Bukan cuma Hanif yang datang berkunjung, tapi juga dua sahabat Hanif saat tinggal di panti, Anton dan Jefri yang membawa istri-istri mereka. Malam itu mereka semua tiba di panti asuhan yang terletak di luar kota dan jauh dari pemukiman penduduk itu. Mereka bermaksud bermalam di sana untuk memberikan penghormatan terakhir buat orang yang telah mengasuh mereka sejak kecil. Mereka menyangka malam itu akan jadi malam yang penuh kedamaian. Mereka segera memahami bahwa mereka salah.",
            "Seorang saudara dan saudari memasuki padang rumput tinggi untuk menyelamatkan seorang anak laki-laki, tetapi mereka segera menyadari bahwa mereka tidak dapat melarikan diri dan sesuatu yang jahat mengintai di rumput",
            "Setelah dilembagakan di rumah sakit jiwa, remaja Korea Su-mi (Yum Jung-ah) bertemu kembali dengan saudara perempuan tercintanya, Su-yeon (Im Soo-jung), dan mereka kembali tinggal di rumah pedesaan mereka. Ayah duda gadis itu (Moon Geun-young) telah menikah lagi, dan saudara kandungnya langsung membenci istri barunya, Eun-joo (Kim Kap-soo). Saat Su-mi dan Su-yeon mencoba untuk melanjutkan kehidupan biasa mereka, kejadian aneh mengganggu rumah tersebut, yang mengarah ke pengungkapan yang mengejutkan dan kesimpulan yang mengejutkan.",
         )

    }
}