<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="学生のための賃貸マンション・賃貸アパートをお探しなら、地域密着型の【○×不動産】にお任せください！駅近、女性専用マンション、敷金礼金なしなど、多種多様な物件を取り扱っております。">
<meta name="keywords" content="○×不動産,学生,賃貸,駅近,一人暮らし,アパート,下宿,敷金礼金なし,不動産">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, user-scalable=yes">
<meta name="format-detection" content="telephone=no">
<title>学生向け賃貸マンション・アパート｜物件数No.1！【○×不動産】</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="js/bxslider/jquery.bxslider.css">
<link rel="stylesheet" href="css/common.css">

<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.min.js"></script>
<script src="js/raindrops.js"></script>
<!-- <script src="js/smoothScroll.js"></script> -->
<script src="js/bxslider/jquery.bxslider.min.js"></script>
<script>
$(document).ready(function(){
//bxSlider
    $('.slider').bxSlider({
        auto: true
    });

//トグルボタン
    $('#headline button').click(function(){
        $('#headline nav').slideToggle();
    })

//フッターのエフェクト
    $('#rain').raindrops({
        color:'#004080',
        waveLength: 700,
        waveHeight: 50,
        rippleSpeed: 0.05,
        density: 0.04
    });

//topボタンの表示
    var topBtn = $('#top_btn');
    topBtn.hide();
    $(window).scroll(function () {
        if ($(this).scrollTop() > 300) {
            topBtn.fadeIn();
        } else {
            topBtn.fadeOut();
        }
    });
    topBtn.click(function () {
        $('body,html').animate({
            scrollTop: 0
        }, 500);
        return false;
    });

});

//g_navのdisplay用　サイズ取得
$(window).resize(function(){
    var w = $(window).width();
    if (w >= 800) {
        $('#g_nav').css({ display: 'flex' });
    } else {
        $('#g_nav').css({ display: 'none' });
    }
});


//タブレット・スマホ用メニューボタン
$(document).on('click', function(evt){
    var w = $(window).width();
    if(w < 800){
        if( $(evt.target).closest('#menu').length ){
            $('#g_nav').css({display: "block"}).animate({right: "0px"});
            $('#wrapper').animate({right: "100px"});
            return;
        }

        $('#g_nav').animate({right: "-100px"},500);
        $('#wrapper').animate({right: "0px"},500,function(){
            $('#g_nav').css({display: "none"});
        });
    }

});
</script>

</head>

<body id="top">
<div id="wrapper">
    <div id="headline">
        <div class="inner flex">
            <h1>学生のための賃貸マンション・賃貸アパートをお探しなら、地域密着型の【○×不動産】</h1>
            <div class="flex">
                <p><span>ゲスト</span>&nbsp;さん</p>
                <button><i class="fa fa-bars" aria-hidden="true"></i></button>
                <nav id="nav">
                    <ul class="flex">
                        <li><a href="#"><i class="fa fa-check-square-o" aria-hidden="true"></i>お気に入り<span>8</span>件</a></li>
                        <li><a href="#">会員登録</a></li>
                        <li><a href="#">ログイン</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
    <header id="header">
        <div class="flex">
            <h2><a href="/estateapp/SearchController"><img src="images/logo.jpg" alt="○×不動産" width="30%" height="50%"></a></h2>
            <ul id="g_nav" class="flex">
                <li><a href="index.jsp">ホーム</a></li>
                <li><a href="#">売りたい</a></li>
                <li><a href="#">リフォーム</a></li>
                <li><a href="#">ご来店予約</a></li>
                <li><a href="#">アクセス</a></li>
                <li><a href="#">お問い合わせ</a></li>
                <li><a href="#">お客様の声</a></li>
            </ul>
        </div>
        <div id="main_image">
            <ul class="slider">
                <li><img src="images/main_img1.jpg"></li>
                <li><img src="images/main_img1.jpg"></li>
                <li><img src="images/main_img1.jpg"></li>
                <li><img src="images/main_img1.jpg"></li>
                <li><img src="images/main_img1.jpg"></li>
            </ul>
        </div>
    </header>
    <main id="main" class="flex">
        <article id="main_contents">
            <form action="/estateapp/SearchController" method="post" name="search" id="search">
                <fieldset id="easy">
                    <legend>お部屋を探す</legend>
                    <table>
                        <tr>
                            <th>賃料</th>
                            <td>
                                <select id="min_money" name="min_money">
                                    <option value="0">下限なし</option>
                                    <% for(double i = 3; i <= 100; i++){
                                    	 if(i < 10){ %>
                                    	<option value="<%= i %>"><%= i %>万円</option>
                                    	<% i = i - 0.5; %>
                                    	<% } else if( i <= 30 ){ %>
                                    		<option value="<%= i %>"><%= i %>万円</option>
                                    	<% } %>
                                    <% } %>
                                    <option value="50">50万円</option>
                                    <option value="100">100万円</option>
                                </select>
                                ～
                                <select id="max_money" name="max_money">
                                    <option value="0">上限なし</option>
                                    <% for(double i = 3; i <= 100; i++){
                                    	 if(i < 10){ %>
                                    	<option value="<%= i %>"><%= i %>万円</option>
                                    	<% i = i - 0.5; %>
                                    	<% } else if( i <= 30 ){ %>
                                    		<option value="<%= i %>"><%= i %>万円</option>
                                    	<% } %>
                                    <% } %>
                                    <option value="50">50万円</option>
                                    <option value="100">100万円</option>
                                </select>
                                <label>
                                    <input type="checkbox" id="expense" name="expense" value="0">管理費・共益費込み
                                </label>
                                <label>
                                    <input type="checkbox" id="deposit" name="deposit" value="0">敷金なし
                                </label>
                                <label>
                                    <input type="checkbox" id="key_money" name="key_money" value="0">礼金なし
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>専有面積</th>
                            <td>
                                <select id="min_area" name="min_area">
                                    <option value="0">下限なし</option>
                                    <% for(int i = 0; i <= 200; i+=5) {
                                    	 if(i < 50){ %>
                                    	 	<option value="<%= i %>"><%= i %>m&sup2;</option>
                                    	 <% } else if(i <= 150) { %>
                                    	 	<option value="<%= i %>"><%= i %>m&sup2;</option>
                                    	 <% } %>
                                    <% } %>
                                    <option value="200">200m&sup2;</option>
                                </select>
                                ～
                                <select id="max_area" name="max_area">
                                    <option value="0">上限なし</option>
                                    <% for(int i = 0; i <= 200; i+=5) {
                                    	 if(i < 50){ %>
                                    	 	<option value="<%= i %>"><%= i %>m&sup2;</option>
                                    	 <% } else if(i <= 150) { %>
                                    	 	<option value="<%= i %>"><%= i %>m&sup2;</option>
                                    	 <% } %>
                                    <% } %>
                                    <option value="200">200m&sup2;</option>
                                </select>
                                <span>※「m&sup2;」と「平米」は同じになります</span>
                            </td>
                        </tr>
                        <tr>
                            <th>間取り</th>
                            <td>
                            <%--
                                <?php
                                    $layouts= array('ワンルーム','1k','1DK','1LDK','2K','2DK','2LDK','3K','3DK','3LDK','4K','4DK','4LDK','5K以上');

                                    $i=0;
                                    foreach($layouts as $layout) {
                                        print "<label><input type='checkbox' id='layout_$i' name='layout[]' value='$layout'>$layout</label>";
                                        $i++;
                                    }
                                ?>
                                --%>

                                <%
                                String[] layouts = {"ワンルーム","1k","1DK","1LDK","2K","2DK","2LDK","3K","3DK","3LDK","4K","4DK","4LDK","5K以上"};
                                int i = 0;
                                for(String layout : layouts){
                                	out.print("<label><input type='checkbox' id='layout_" + i + "' name='layout_" + i + "' value='" + layout + "'>"+ layout + "</label>");
                                	i++;
                                }
                                %>
                            </td>
                        </tr>
                        <tr>
                            <th>駅から徒歩</th>
                            <td>
                                <label>
                                    <input type="radio" id="walk_0" name="walk" value="0" checked>指定なし
                                </label>
                                <label>
                                    <input type="radio" id="walk_1" name="walk" value="1">1分以内
                                </label>
                                <label>
                                    <input type="radio" id="walk_2" name="walk" value="5">5分以内
                                </label>
                                <label>
                                    <input type="radio" id="walk_3" name="walk" value="7">7分以内
                                </label>
                                <label>
                                    <input type="radio" id="walk_4" name="walk" value="10">10分以内
                                </label>
                                <label>
                                    <input type="radio" id="walk_5" name="walk" value="15">15分以内
                                </label>
                                <label>
                                    <input type="radio" id="walk_6" name="walk" value="20">20分以内
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>築年数</th>
                            <td>
                                <label>
                                    <input type="radio" id="age_0" name="age" value="0" checked>指定なし
                                </label>
                                <label>
                                    <input type="radio" id="age_1" name="age" value="1">新築
                                </label>
                                <label>
                                    <input type="radio" id="age_2" name="age" value="3">3年以内
                                </label>
                                <label>
                                    <input type="radio" id="age_3" name="age" value="5">5年以内
                                </label>
                                <label>
                                    <input type="radio" id="age_4" name="age" value="10">10年以内
                                </label>
                                <label>
                                    <input type="radio" id="age_5" name="age" value="15">15年以内
                                </label>
                                <label>
                                    <input type="radio" id="age_6" name="age" value="20">20年以内
                                </label>
                                <label>
                                    <input type="radio" id="age_7" name="age" value="25">25年以内
                                </label>
                                <label>
                                    <input type="radio" id="age_8" name="age" value="30">30年以内
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>人気のこだわり条件</th>
                            <td>
                                <% String[] preferences = {"バス・トイレ別","2階以上","室内洗濯機置場","エアコン","駐車場あり","オートロック","追炊機能","ペット相談可"};
                                	int j = 0;
                                	for(String preference : preferences){
                                		out.print("<label><input type='checkbox' id='preferences_" + j + "' name='preferences_" + j + "' value='" + preference + "'>"+ preference + "</label>");
                                    	j++;
                                	}
                                %>
                            </td>
                        </tr>
                    </table>
                    <p><input type="submit" name="simple_search" value="この条件で検索する"></p>
                </fieldset>
                <%--
                <fieldset id="indetail" disabled>
                    <legend>さらに詳しいこだわり条件</legend>
                    <table>
                        <tr>
                            <th>位置</th>
                            <td>
                                <label>
                                    <input type="checkbox" id="" name="" value="">1階の物件
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">2階以上
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">最上階
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">角部屋
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">南向き
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>キッチン</th>
                            <td>
                                <label>
                                    <input type="checkbox" id="" name="" value="">ガスコンロ設置済
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">IHコンロ
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">コンロ2口以上
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">カウンターキッチン
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">システムキッチン
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>バス・トイレ</th>
                            <td>
                                <label>
                                    <input type="checkbox" id="" name="" value="">バス・トイレ別
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">追焚機能
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">温水洗浄便座
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">浴室乾燥機
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">独立洗面所
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">室内洗濯機置場
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>冷暖房</th>
                            <td>
                                <label>
                                    <input type="checkbox" id="" name="" value="">エアコン
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">床暖房
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">灯油暖房
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">ガス暖房
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>駐車場・駐輪場</th>
                            <td>
                                <label>
                                    <input type="checkbox" id="" name="" value="">駐車場あり
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">駐輪場あり
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">バイク置場あり
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>建物設備</th>
                            <td>
                                <label>
                                    <input type="checkbox" id="" name="" value="">エレベーター
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">宅配ボックス
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">敷地内ゴミ置場
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">オートロック
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">管理人常駐
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">TVモニタ付きインターホン
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">都市ガス
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">オール電化
                                </label>
                                <label>
                                    <input type="checkbox" id="" name="" value="">フローリング
                                </label>
                            </td>
                        </tr>
                    </table>
                    <p><input type="submit" value="この条件で検索する"></p>
                </fieldset>
                --%>
            </form>
        </article>
        <nav id="sidebar">
            <section>
                <a href="#">
                    <figure>
                        <img src="images/life_style.jpg" alt="ライフスタイル別物件">
                        <figcaption>ライフスタイル別物件</figcaption>
                    </figure>
                </a>
            </section>
            <section>
                <a href="#">
                    <figure>
                        <img src="images/ninki.jpg" alt="人気のこだわり物件">
                        <figcaption>人気のこだわり物件</figcaption>
                    </figure>
                </a>
            </section>
            <section>
                <a href="#">
                    <figure>
                        <img src="images/hoken.jpg" alt="各種保険について">
                        <figcaption>各種保険について</figcaption>
                    </figure>
                </a>
            </section>
            <%--
            <div id="recent">
                <h3>最近見た物件</h3>
                <aside>
                    <a href="#" class="flex">
                        <figure><img src="#" alt=""></figure>
                        <table>
                            <tr>
                                <th>建物名</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>住所</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>交通/徒歩</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>間取り</th>
                                <td></td>
                            </tr>
                        </table>
                    </a>
                </aside>
                <aside>
                    <a href="#" class="flex">
                        <figure><img src="#" alt=""></figure>
                        <table>
                            <tr>
                                <th>建物名</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>住所</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>交通/徒歩</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>間取り</th>
                                <td></td>
                            </tr>
                        </table>
                    </a>
                </aside>
                <aside>
                    <a href="#" class="flex">
                        <figure><img src="#" alt=""></figure>
                        <table>
                            <tr>
                                <th>建物名</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>住所</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>交通/徒歩</th>
                                <td></td>
                            </tr>
                            <tr>
                                <th>間取り</th>
                                <td></td>
                            </tr>
                        </table>
                    </a>
                </aside>
            </div>
            --%>
        </nav>
    </main>
    <p id="rain"></p>
    <footer id="footer">
        <div class="inner">
            <ul class="flex">
                <li><a href="#">会社概要</a></li>
                <li><a href="#">会員規約</a></li>
                <li><a href="#">プライバシーポリシー</a></li>
                <li><a href="#">求人情報</a></li>
            </ul>
            <p><small>&copy;2020 ○×不動産</small></p>
        </div>
    </footer>
    <p id="top_btn" class="btn"><a href="#top"><span>TOP</span></a></p>
    <p id="menu"><a href="#"><span>MENU</span></a></p>
</div>
</body>
</html>
