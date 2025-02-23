package lat.pam.hellotoast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var mCount = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)

        buttonCountUp.setOnClickListener(View. OnClickListener {
            mCount++;
            if (mShowCount != null)
                mShowCount.text = mCount.toString()
        })

        buttonToast.setOnClickListener(View.OnClickListener {
            val tulisan: String = mShowCount?.text.toString()
            val toast: Toast = Toast.makeText(this, "Angka yang dimunculkan "+tulisan, Toast.LENGTH_SHORT)
            toast.show()
        })

        buttonSwitchPage.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity2::class.java).apply {
                putExtra("key_nama", "Aldy Rialdy")
                putExtra("key_umur", 25)
            }
            startActivity(intent)
        })

        buttonBrowser.setOnClickListener(View.OnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)

        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

}