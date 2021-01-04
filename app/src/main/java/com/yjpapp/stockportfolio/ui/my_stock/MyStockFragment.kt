package com.yjpapp.stockportfolio.ui.my_stock

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.yjpapp.stockportfolio.R
import com.yjpapp.stockportfolio.database.model.MyStockInfo
import com.yjpapp.stockportfolio.network.YahooFinanceProtocolManager
import com.yjpapp.stockportfolio.network.model.Price
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

//TODO 내가 갖고있는 주식 실시간 변동 사항 및 수익 분석 할 수 있는 기능 만들기.
class MyStockFragment: Fragment() {
    private lateinit var mContext: Context
    private lateinit var mRootView: View

    private lateinit var txt_current_price_data: TextView
    private lateinit var txt_current_price_change_data: TextView
    private lateinit var txt_current_price_change_percent_data: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var myStockListAdapter: MyStockListAdapter
    private lateinit var allMyStockList: ArrayList<MyStockInfo>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        mRootView = inflater.inflate(R.layout.fragment_my_stock, container, false)
        initLayout()
        initData()
        return mRootView
    }

    private var menu: Menu? = null
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_my_stock, menu)
        this.menu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_MyStockFragment_Add -> {
                //TODO 추가 메뉴 구성.
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initData(){

        val symbol = "005930.KS"
        val region = "KR"
        YahooFinanceProtocolManager.getInstance(mContext).getStockProfile(symbol, region,
            object: Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if(response.code() == 200 || response.code() == 204){
                    try {
                        val jsonObject = JSONObject(response.body().toString())
                        val priceJSONArray = jsonObject.getJSONObject("price").toString()
                        val price: Price = Gson().fromJson(priceJSONArray, Price::class.java)
                        Log.d("YJP", "price = $price")

                        Thread(Runnable {
                            // performing some dummy time taking operation
                            activity?.runOnUiThread {
                                val currentPrice = price.regularMarketPrice.raw.toString()
                                val change = (price.regularMarketPrice.raw.toDouble() - price.regularMarketPreviousClose.raw.toDouble()) //변동 가격
                                val changePercent = price.regularMarketChangePercent.fmt
//                                txt_current_price_data.text = currentPrice
//                                if(change<0){
//                                    txt_current_price_change_data.setTextColor(mContext.getColor(R.color.color_e52b4e))
//                                }else{
//                                    txt_current_price_change_data.setTextColor(mContext.getColor(R.color.green))
//                                }
//                                txt_current_price_change_data.text = "$change ($changePercent)"
//                                txt_current_price_change_percent_data.text = changePercent //주가 변동 퍼센트
                            }
                        }).start()

                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                Log.d("RequestResult", "RetrofitExample, Type : get, Result : onFailure, Error Message : " + t.message)
            }
        })
    }

    private fun initLayout(){
        setHasOptionsMenu(true)
//        txt_current_price_data = mRootView.findViewById(R.id.txt_current_price_data)
//        txt_current_price_change_percent_data = mRootView.findViewById(R.id.txt_current_price_change_percent_data)
        initRecyclerView()
    }
    private fun initRecyclerView(){
//        recyclerView = mRootView.findViewById(R.id.recyclerview_MyStockFragment)
//        layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
//        layoutManager.reverseLayout = true
//        layoutManager.stackFromEnd = true

//        recyclerView.layoutManager = layoutManager
//
//        myStockListAdapter = MyStockListAdapter(allMyStockList)
//        recyclerView.adapter = myStockListAdapter
//        recyclerView.itemAnimator = FadeInAnimator()
    }
}