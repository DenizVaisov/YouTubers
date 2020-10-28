package com.example.kmmapp.bloggers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kmmapp.androidApp.R

 class BloggerActivity : AppCompatActivity(), BloggerClickListener {
     private lateinit var list: RecyclerView
     val bloggers = mutableListOf<Blogger>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blogger)

        list = findViewById(R.id.list_recycler_view)

        bloggers.add(Blogger("https://www.tubefilter.com/wp-content/uploads/2020/02/pewdiepie-return-youtube.jpg", "PewDiePie", "Фе́ликс А́рвид У́льф Че́льберг", 30, "Пьюдипай (англ. PewDiePie; настоящее имя — Фе́ликс А́рвид У́льф Че́льберг, швед. Felix Arvid Ulf Kjellberg; род. 24 октября 1989, Гётеборг, Швеция) — шведский видеоблогер и деятель шоу-бизнеса, создатель одноимённого канала на YouTube. C 15 августа 2013 года по 15 апреля 2019 года имел наибольшее количество подписчиков на платформе. Согласно Forbes, его доход на 2018 год составил около 15,5 млн долларов."))
        bloggers.add(Blogger("https://i.insider.com/5e453e6f96eee6567a49fbe2?width=896&format=jpeg", "JackSepticEye", "Шон Уильям МакЛоглин",30, "Личная жизнь\n" +
                "Шон МакЛоглин родился 7 февраля 1990 года в деревне Балликамбер, Графство Оффали (провинция Ленстер), Ирландия. Cамый младший ребёнок в семье, имеет двух братьев и двух сестёр. \n" +
                "\n" +
                "С детства начал увлекаться видеоиграми. Также в подростковом возрасте Шон был барабанщиком инди-хэви-металл группы под названием «Raised to the Ground». В конце 2000-х годов он окончил среднюю школу по специальности «Музыкальные технологии».\n" +
                "\n" +
                "Происхождение названия канала\n" +
                "В Ирландии «Джек» является общим прозвищем для имени «Шон», и его мать и друзья назвали его так. «Septiceye» получилось из инцидента в школе: во время игры в футбол кто-то попал Шону мячом в висок, после чего его глаз выглядел устрашающе. По словам Джека, рана кровоточила в течение некоторого времени и заразилась через несколько недель. После чего друзья также называли его «Джеком», и кто-то — «Septiceye» либо сразу обоими прозвищами. Комбинация двух прозвищ — «Jacksepticeye» — и дала новое название каналу (септик — это медицинский термин, относящийся к системной инфекции)\n"
        ))

        val adapter = BloggerAdapter(bloggers, this)
        list.layoutManager = GridLayoutManager(this, 2)
        list.adapter = adapter
    }

    override fun onBloggerClickListener(blogger: Blogger) {
        val intent = Intent(this, BloggerInfoActivity::class.java)
        intent.putExtra("bloggers", blogger)
        startActivity(intent)
    }
}