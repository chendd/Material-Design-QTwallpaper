package us.wili.qtwallpaper.utils;


/**
 * Created by qiu on 5/12/15.
 */
public class JsonUtils {

//    public static ArrayList<Picture> parsePictureList(String json){
//        ArrayList<Picture>list =new ArrayList<Picture>();
//        try {
//            JSONObject jsonObject = (JSONObject) new JSONObject(json);
//            int count=jsonObject.getInt("count");
//            JSONArray array = jsonObject.getJSONArray("picture");
//            for(int i=0;i<array.length();i++){
//                JSONObject picObj = (JSONObject)array.opt(i);
//                us.wili.qtwallpaper.object.Picture picture=new Picture();
//                //  picture.createTime=new Time(picObj.getString("create_time"));
//                picture.like=picObj.getString("like");
//                picture.id=picObj.getInt("id");
//                //   picture.desc=picObj.getString("desc");
//                picture.name=picObj.getString("name");
//                //   picture.download=picObj.getInt("download");
//                //   picture.share=picObj.getInt("share");
//                picture.url=picObj.getString("url");
//                //   picture.star=picObj.getInt("star");
//                list.add(picture);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public static ArrayList<Category> parseCategoryList(String json){
//        ArrayList<Category>list =new ArrayList<Category>();
//        try {
//            JSONObject jsonObject = (JSONObject) new JSONObject(json);
//            int count=jsonObject.getInt("count");
//            JSONArray array = jsonObject.getJSONArray("category");
//            for(int i=0;i<array.length();i++){
//                JSONObject catObj = (JSONObject)array.opt(i);
//                Category category=new Category();
//                category.special=catObj.getBoolean("special");
//                category.screen_name=catObj.getString("screen_name");
//                category.name=catObj.getString("name");
//                category.cover=catObj.getString("cover");
//                list.add(category);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//
//
//    public static ArrayList<String> parseApplicantList(String json) {
//        ArrayList<String> list = new ArrayList<String>();
//        try {
//            JSONObject jsonObject = (JSONObject) new JSONObject(json).getJSONArray("info").opt(2);
//            JSONArray array = jsonObject.getJSONArray("applicants");
//            for(int i=0;i<array.length();i++){
//                JSONObject jo = (JSONObject)array.opt(i);
//                list.add(jo.getString("name"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public static ArrayList<String> parseDownloadList(String json) {
//        ArrayList<String> list = new ArrayList<String>();
//        try {
//            JSONObject jsonObject = (JSONObject) new JSONObject(json).getJSONArray("info").opt(0);
//            JSONArray array = jsonObject.getJSONArray("data");
//            for(int i=0;i<array.length();i++){
//                JSONObject jo = (JSONObject)array.opt(i);
//                list.add(jo.getString("token"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public static ArrayList<String> parseFriendsList(String json) {
//        ArrayList<String> list = new ArrayList<String>();
//        try {
//            JSONObject jsonObject = (JSONObject) new JSONObject(json).getJSONArray("info").opt(1);
//            JSONArray array = jsonObject.getJSONArray("friends");
//            for(int i=0;i<array.length();i++){
//                JSONObject jo = (JSONObject)array.opt(i);
//                list.add(jo.getString("name"));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

}

