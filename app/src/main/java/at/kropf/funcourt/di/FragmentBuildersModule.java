/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package at.kropf.funcourt.di;

import at.kropf.funcourt.ui.WelcomeFragment;
import at.kropf.funcourt.ui.login.LoginFragment;
import at.kropf.funcourt.ui.registration.RegistrationFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract RegistrationFragment contributeRegistrationFragment();

    @ContributesAndroidInjector
    abstract WelcomeFragment contributeWelcomeFragment();

    @ContributesAndroidInjector
    abstract LoginFragment contributeLoginFragment();
}
