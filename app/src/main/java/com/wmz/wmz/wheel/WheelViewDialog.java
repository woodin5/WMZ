package com.wmz.wmz.wheel;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.wmz.wmz.R;

public class WheelViewDialog extends Dialog {
	public WheelViewDialog(Context context, int theme) {
		super(context, theme);
	}

	protected WheelViewDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

	public void setList(String[] list) {
		this.data = list;
		if (adapter != null) {
			adapter.notifyDataSetChanged();
		}
	}

	public WheelViewDialog(Context context) {
		super(context, R.style.dialog);
	}

	public WheelViewDialog(Context context, String title, String[] list,
			int defaultPosition) {
		super(context, R.style.dialog);
		this.data = list;
		this.position = defaultPosition;
		this.title = title;
	}

	public WheelViewDialog(Context context, String title, String[] list,
			int defaultPosition, OnWheelSelectedDialogListener clickListener) {
		super(context, R.style.dialog);
		this.data = list;
		this.clickListener = clickListener;
		if (defaultPosition < 0) {
			this.position = 0;
		} else {
			this.position = defaultPosition;
		}
		this.title = title;
	}

	private String[] data = { "" };
	private WheelAdapter adapter;
	private WheelView mWheelView;
	private String title;
	private int position;

	public void setPosition(int defaultPosition) {
		this.position = defaultPosition;
	}

	public void getPosition(int defaultPosition) {
		this.position = defaultPosition;
	}

	private TosAdapterView.OnItemSelectedListener mListener = new TosAdapterView.OnItemSelectedListener() {
		@Override
		public void onItemSelected(TosAdapterView<?> parent, View view,
				int position, long id) {
			WheelViewDialog.this.position = mWheelView
					.getSelectedItemPosition();

		}

		@Override
		public void onNothingSelected(TosAdapterView<?> parent) {
		}
	};
	private TextView tv_dialog_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wheel_dialog);

		mWheelView = (WheelView) findViewById(R.id.wheel);
		tv_dialog_title = (TextView) findViewById(R.id.tv_dialog_title);
		tv_dialog_title.setText(title);
		mWheelView.setScrollCycle(true);
		adapter = new WheelAdapter(getContext(), data);
		mWheelView.setAdapter(adapter);

		mWheelView.setSelection(position, true);

		mWheelView.setOnItemSelectedListener(mListener);
		mWheelView.setUnselectedAlpha(0.3f);
		((WheelTextView) mWheelView.getSelectedView()).setTextSize(20);
		findViewById(R.id.btn_done).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {

						if (clickListener != null) {
							clickListener.onDone(data,
									mWheelView.getSelectedItemPosition());
						}
						dismiss();
					}
				});
	}

	@Override
	public void show() {
		super.show();
		Window window = getWindow();
		window.setLayout(-1, -2);
		window.setGravity(Gravity.BOTTOM); // ����dialog��ʾ��λ��
		window.setWindowAnimations(R.style.dialog_menu); // ��Ӷ���
	}

	private OnWheelSelectedDialogListener clickListener;

	public OnWheelSelectedDialogListener getOnWheelSelectedDialogListener() {
		return clickListener;
	}

	public void setOnWheelSelectedDialogListener(
			OnWheelSelectedDialogListener clickListener) {
		this.clickListener = clickListener;
	}

	public interface OnWheelSelectedDialogListener {
		void onDone(String[] list, int position);
	}
}
