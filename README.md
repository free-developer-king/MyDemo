

###两个，三个Activity之间的相互跳转，仿京东购物选择地址.



[代码对应的博客](http://blog.csdn.net/u014702332/article/details/53609819)


这两天在实现一个类似于京东选择地址的功能:从订单中选择已经存在的地址或者去添加新的地址，这就需要涉及到2个或者3个Activity之中间的的跳转。
我这里写了3个Activity，我称为MainActivity(当前需要地址页),AActivity（选择地址页）,BActivity（添加或者编辑地址页）
1. **直接去选择地址，从MainActivity 到AActivity，然后再回到MainActivity**
2. **没有现成地址，需要自己去添加这个时候的流程是从MainActivity-->AActivity--- >BActivity------>AActivity---->MainActivity**




#####情况1 从MainActivity 到AActivity，然后再回到MainActivity,直接去选择已经存在的地址：

从MainActivity 跳到AActivity
```
    @OnClick(R.id.btn_next)
    public void onClick() {
        Intent intent = new Intent(MainActivity.this, AActivity.class);
        startActivityForResult(intent, TYPE_A);
    }
```

从AActivity回到MainActivity
```
    private void backMainActivity(String text) {
        Intent intent = new Intent();
        intent.putExtra(FORM_ACT, text);
        setResult(RESULT_OK, intent);
        finish();
    }
```

上面这些大家都知道，也是经常见到的，
#####情况2**没有现成地址，需要自己去添加这个时候的流程是从MainActivity-->AActivity--- >BActivity------>AActivity---->MainActivity**

这里就需要AActivity进入BActivity
```
  case R.id.btn_next_2:
                Intent intent3 = new Intent(AActivity.this, BActivity.class);
                startActivityForResult(intent3, B_ACTIVITY);
                break;
```

注意一下再从BActivity回到AActivity
```
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (RESULT_OK == resultCode) {
            if (B_ACTIVITY == requestCode) {
                String str = data.getStringExtra(FORM_ACT);
                backMainActivity(str);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

```
上面这里是关键，所以一定要注意一下.












