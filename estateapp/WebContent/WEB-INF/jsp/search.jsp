<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="estateapp.model.entity.RentalProperty" %>
<%@ page import="java.util.List" %>
<%
	List<RentalProperty> rpList = (List<RentalProperty>)request.getAttribute("rentalPropertyList");
%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="description" content="学生のための賃貸マンション・賃貸アパートをお探しなら、地域密着型の【○×不動産】にお任せください！駅近、女性専用マンション、敷金礼金なしなど、多種多様な物件を取り扱っております。">
<meta name="keywords" content="○×不動産,学生,賃貸,駅近,一人暮らし,アパート,下宿,敷金礼金なし,不動産">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=10.0, user-scalable=yes">
<meta name="format-detection" content="telephone=no">
<title>検索結果一覧｜学生向け賃貸マンション・アパート｜物件数No.1！【○×不動産】</title>
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
    var topBtn = $('.btn');
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

<body id="search">
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
    <main id="main">
        <article id="main_contents">
            <h2>物件一覧</h2>
            <%
            	if(rpList.size() == 0){
            		out.print("<p style='font-size: 36px; text-align: left; margin-top: 20px;'>該当する物件がありませんでした。</p>");
            	} else {
            		out.print("<p><span>" + rpList.size() + "</span>件</p>");

            	}
            %>

            <% for(RentalProperty rp : rpList){
             %>
                <a href="#">
                <section>
                    <header class="flex">
                        <p class="favorite"><label><input type="checkbox" id="check" name="check" value="on">お気に入り</label></p>
                        <p class="name">
                            <%= rp.getEstateName() %>
                        </p>
                    </header>
                    <aside class="flex">
                        <figure><img src="images/gaikan.jpg" width="100px" height="100px"></figure>
                        <table>
                            <tr>
                                <th>住所</th>
                                <td>
                                    <%= rp.getAddress() %>
                                </td>
                            </tr>
                            <tr>
                                <th>交通機関</th>
                                <td>
                                    <%= rp.getNearStation() %> (徒歩 <%= rp.getWalkTimeMin() %> 分)
                                </td>
                            </tr>
                            <tr>
                                <th>築年数</th>
                                <td>
                                    <%
                                    	if(rp.getAgeYear() == 0){
                                    		out.print("不明");
                                    	} else if( 0 < rp.getAgeYear() && rp.getAgeYear() < 1 ){
                                    		out.print("新築");
                                    	} else {
                                    		out.print("築 " + rp.getAgeYear() + " 年");
                                    	}
                                    %>
                                </td>
                            </tr>
                        </table>
                    </aside>
                    <table class="property">
                        <tr>
                            <td>階数</td>
                            <td>賃料</td>
                            <td>管理費</td>
                            <td>敷/礼/保/等</td>
                            <td>間取り</td>
                            <td>こだわり条件</td>
                        </tr>
                        <tr>
                            <td>
                            	<%= rp.getFloor() %> 階 / <%= rp.getBuilding_floors()  %> 階建
                            </td>
                            <td>
                                <span class="money"><%= rp.getRentFeeYen() / 10000 %></span>万円
                            </td>
                            <td>
                                <% if(rp.getManagementFeeYen() == 0){
                                	out.print("-");
                                } else {
                                	out.print((rp.getManagementFeeYen() / 10000) + "万円");
                                }
                                %>
                            </td>
                            <td>
                                <%
                                	if(rp.getDepositYen() == 0){
                                		out.print("-");
                                	} else {
                                		out.print( (rp.getDepositYen() / 100000) + "ヶ月分" );
                                	}
                                %>
                                /
                                <%
                                	if( rp.getKeyMoneyYen() == 0){
                                		out.print("-");
                                	}else {
                                		out.print( (rp.getKeyMoneyYen() / 100000) + "ヶ月分" );
                                	}
                                %>
                                /
                                <%
                                	if( rp.getExMoney1Yen() == 0){
                                		out.print("-");
                                	}else {
                                		out.print( (rp.getExMoney1Yen() / 10000) + "ヶ月分" );
                                	}
                                %>
                                /
                                <%
                                	if( rp.getExMoney2Yen() == 0){
                                		out.print("-");
                                	}else {
                                		out.print( (rp.getExMoney2Yen() / 10000) + "ヶ月分" );
                                	}
                                %>

                            </td>
                            <td>
                                <%= rp.getLayout() %>
                                ( <%= rp.getAreaSquareMeter() %> m&sup2 )
                            </td>
                            <td>
                                <?php echo h($data['preferences']); ?>
								<%
									if(rp.isSeparatedBathToilet()) out.print("バストイレ別 ");
                                	if(rp.getFloor() >= 2) out.print("2階以上 ");
                                	if(rp.isHasWahserSpace()) out.print("洗濯機置場有 ");
                                	if(rp.isHasAircon()) out.print("エアコン有 ");
                                	if(rp.isHasCarParking()) out.print("駐車場有 ");
                                	if(rp.isHasAutolock()) out.print("オートロック ");
                                	if(rp.isHasReheatBath()) out.print("追炊機能有 ");
                                	if(rp.isCanHavePet()) out.print("ペット相談可 ");
								%>
                            </td>
                        </tr>
                    </table>
                </section>
                </a>
                <% } %>
                <a href="/estateapp/SearchController">トップページへもどる</a>
        </article>

        <nav id="sidebar">
            <div class="flex">
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
            </div>
			<%--
            <div id="recent">
                <h3>最近見た物件</h3>
                <div class="flex">
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
    <P id="page_back" class="btn"><a href="#" onClick="history.back()"><span>再設定</span></a></P>
    <p id="top_btn" class="btn"><a href="#search"><span>TOP</span></a></p>
    <p id="menu"><a href="#"><span>MENU</span></a></p>
</div>
</body>
</html>
