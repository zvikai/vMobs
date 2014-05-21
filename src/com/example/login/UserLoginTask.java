package com.example.login;

import android.content.Intent;
import android.os.AsyncTask;

import com.example.testApp.MainTabActivity;
import com.example.testApp.R;

/**
 * Represents an asynchronous login/registration task used to authenticate the
 * user.
 */
public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
	/**
	 * 
	 */

	private LoginActivity loginActivity;

	/**
	 * @param loginActivity
	 */
	UserLoginTask(LoginActivity loginActivity) {
		this.loginActivity = loginActivity;
	}

	@Override
	protected Boolean doInBackground(Void... params) {
		// TODO: attempt authentication against a network service.

		try {
			// Simulate network access.
			Thread.sleep(500);
		} catch (InterruptedException e) {
			return false;
		}
		return true;
	}

	@Override
	protected void onPostExecute(final Boolean success) {
		loginActivity.mAuthTask = null;
		loginActivity.showProgress(false);

		if (success) {
			Intent intent = new Intent(loginActivity, MainTabActivity.class);
			loginActivity.startActivity(intent);
		} else {
			loginActivity.passwordView.setError(loginActivity
					.getString(R.string.error_incorrect_password));
			loginActivity.passwordView.requestFocus();
		}
	}

	@Override
	protected void onCancelled() {
		loginActivity.mAuthTask = null;
		loginActivity.showProgress(false);
	}
}