1 app build.gradle中添加
//目录选择器
android{
    repositories {
        maven {
            url "https://jitpack.io"
        }
    }
}

dependencies{
    compile 'com.github.guardian:Option:e933c3a31d'
    compile project(path: ':directorychooser')
}

2 代码中使用
Activity中
getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, new DirChooserFragment()).commit();
Fragment中
 class DirChooserFragment extends Fragment implements DirectoryChooserFragment.OnFragmentInteractionListener{
        String tag = "DirChooser";
        Button btn = null;
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            btn = new Button(getContext());
            btn.setText("choose");
            return btn;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            DirectoryChooserConfig config = new DirectoryChooserConfig();
            //新建目录的目录名
            config.newDirectoryName = "WmzChooser";
            final DirectoryChooserFragment fragmentDialog =  DirectoryChooserFragment.newInstance(config);
            final Fragment fragment = this;
            //点击事件，显示目录选择器
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentDialog.setTargetFragment(fragment,0);
                    fragmentDialog.show(getFragmentManager(), tag);
                }
            });
        }

        @Override
        public void onSelectDirectory(@NonNull String path) {
            btn.setText("path=" + path);
            DirectoryChooserFragment fragmentDialog = (DirectoryChooserFragment) getSupportFragmentManager().findFragmentByTag(tag);
            fragmentDialog.dismiss();
        }

        @Override
        public void onCancelChooser() {
            btn.setText("cancel");
            DirectoryChooserFragment fragmentDialog = (DirectoryChooserFragment) getSupportFragmentManager().findFragmentByTag(tag);
            fragmentDialog.dismiss();
        }
    }