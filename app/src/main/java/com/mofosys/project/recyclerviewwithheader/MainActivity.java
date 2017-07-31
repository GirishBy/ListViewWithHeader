package com.mofosys.project.recyclerviewwithheader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<TestModel> testModels;
    ArrayList<Object> arrayList_new;
    private int aaa = 0, bbb = 0, ccc = 0, ddd = 0, eee = 0;
    boolean jan_bool = true, feb_bool = true, march_bool = true, april_bool = true, may_bool = true, june_bool = true, july_bool = true, august_bool = true;
    private int feb_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.test);
        testModels = new ArrayList<>();
        arrayList_new = new ArrayList();

        listView.setAdapter(new TestAdapter(this, arrayList_new));

        loadJSONFromAsset();

    }

    public void loadJSONFromAsset() {
        String json = null;
        try {

            InputStream is = getAssets().open("sample.txt");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();

        }


        parseJson(json);

    }

    public void parseJson(String response) {

        try {

            //Log.i("TEST", "res : " + response);
            JSONArray jsonArray = new JSONArray(response);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                TestModel testModel = new TestModel();
                testModel.setProduct_name(jsonObject1.getString("product_name"));
                testModel.setProduct_ref_number(jsonObject1.getString("product_ref_number"));
                testModel.setShipment_qty(jsonObject1.getString("shipment_qty"));
                testModel.setSupplier_product_price(jsonObject1.getString("supplier_product_price"));
                String date_str = jsonObject1.getString("date");


                DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
                Date date = null;
                try {
                    date = format.parse(date_str);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                testModel.setDate_d(date);

                testModels.add(testModel);
            }

            Log.i("TEST", "Before: " + testModels.get(1).getDate_d());

            if (testModels.size() > 0) {

                Collections.sort(testModels, new Comparator<TestModel>() {
                    @Override
                    public int compare(final TestModel object1, final TestModel object2) {
                        return object1.getDate_d().compareTo(object2.getDate_d());
                    }
                });
            }

            Log.i("TEST", "After : " + testModels.get(1).getDate_d());


            for (int i = 0; i < testModels.size(); i++) {

                Date date = testModels.get(i).getDate_d();
                int i1 = date.getMonth();

                if (i1 == 0) {

                    aaa += Integer.parseInt(testModels.get(i).getShipment_qty());
                }

                if (i1 == 1) {

                    feb_total += Integer.parseInt(testModels.get(i).getShipment_qty());
                }

                if (i1 == 2) {

                    bbb += Integer.parseInt(testModels.get(i).getShipment_qty());
                }

                if (i1 == 3) {

                    ccc += Integer.parseInt(testModels.get(i).getShipment_qty());
                }

                if (i1 == 5) {

                    ddd += Integer.parseInt(testModels.get(i).getShipment_qty());
                }

                if (i1 == 6) {

                    eee += Integer.parseInt(testModels.get(i).getShipment_qty());
                }
            }


            for (int i = 0; i < testModels.size(); i++) {

                Date date = testModels.get(i).getDate_d();
                int i1 = date.getMonth();

                if (i1 == 0) {
                    if (jan_bool) {
                        arrayList_new.add("JAN" + "/" + String.valueOf(aaa));
                        jan_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));
                    aaa += Integer.parseInt(testModels.get(i).getShipment_qty());

                } else if (i1 == 1) {

                    if (feb_bool) {
                        arrayList_new.add("FEB" + "/" + String.valueOf(feb_total));
                        feb_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                } else if (i1 == 2) {

                    if (march_bool) {
                        arrayList_new.add("MARCH" + "/" + String.valueOf(bbb));
                        march_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                } else if (i1 == 3) {

                    if (april_bool) {
                        arrayList_new.add("APRIL" + "/" + String.valueOf(ccc));
                        april_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                } else if (i1 == 4) {

                    if (may_bool) {
                        arrayList_new.add("MAY/05");
                        may_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                } else if (i1 == 5) {

                    if (june_bool) {
                        arrayList_new.add("JUNE" + "/" + String.valueOf(ddd));
                        june_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                } else if (i1 == 6) {

                    if (july_bool) {
                        arrayList_new.add("JULY" + "/" + String.valueOf(eee));
                        july_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                } else if (i1 == 7) {

                    if (august_bool) {
                        arrayList_new.add("AUGUST/08");
                        august_bool = false;
                    }
                    arrayList_new.add(testModels.get(i));

                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
