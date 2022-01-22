package com.prongbang.snaplayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.prongbang.snaplayout.databinding.ActivityMainBinding
import com.prongbang.snaplayout.databinding.ViewBizCardBinding
import com.prongbang.snapxlayout.SnapshotXLayout

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        snapshotLayout()
    }

    private fun snapshotLayout() {
        val snapXLayout = SnapshotXLayout(this)

        // Initial view
        val view = snapXLayout.inflate(R.layout.view_biz_card)
        val bizBinding = ViewBizCardBinding.bind(view)
        bizBinding.apply {
            nameText.text = "Devไปวันๆ"
            positionText.text = "Co-Founder"
            departmentText.text = "R&D and Innovation Labs"
            companyText.text = "Innotech Development Co., Ltd."
            addressText.text = "Bangkok, Thailand"
            phoneText.text = "M +66 (0) 9 8 765 XXXX"
            emailText.text = "info@innotechdev.co.th"
        }

        // snapshot
        val bitmap = snapXLayout.snapshot(bizBinding)

        // Preview
        binding.bizCardImage.setImageBitmap(bitmap)
    }

}