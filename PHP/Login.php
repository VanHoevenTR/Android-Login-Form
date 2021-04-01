<?PHP
$data = '';

$user = 'user';
$pass = 'pass';
$key = 'key';

if (!empty($_REQUEST) ) {
    if (!empty($_REQUEST[$user]) && !empty($_REQUEST[$pass]) && !empty($_REQUEST[$key]) ) {
        if ($_REQUEST[$user] == 'Mahmoud Alaa' && $_REQUEST[$pass] == 'EGMahmoudGaming' && $_REQUEST[$key] == 'MG') {
            $data = '1|'.md5($_REQUEST[$user] . $_REQUEST[$pass] . $_REQUEST[$key]) .'|User: ' . $_REQUEST[$user] . ' successfully logged in!';
        }else{
            $data = '0|'.md5(date('Y-m-d h:i:s').rand(1, 9999)).'|Incorrect username or password or key !!';
        }
    }else{
        $data = '0|'.md5(date('Y-m-d h:i:s').rand(1, 9999)).'|Fill in username and password and key !!';
    }
}

header('Content-Type: text/plain');
echo $data;