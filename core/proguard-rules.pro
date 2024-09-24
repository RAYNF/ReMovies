-dontwarn java.lang.invoke.StringConcatFactory

-keep class com.di.** { *; }
-keepclassmembers class com.di.** { *; }

-keep class com.domain.usecase.** { *; }
-keepclassmembers class com.domain.usecase.** { *; }

-keep class com.databinding.** { *; }
-keepclassmembers class com.databinding.** { *; }

-keep class com.ui.** { *; }
-keepclassmembers class com.ui.** { *; }

-keep class com.data.** { *; }
-keepclassmembers class come.data.** { *; }

# Keep class com.domain.model.Movie and all its fields
-keep class com.domain.model.Movie { *; }

# Keep class com.domain.repository.IMovieRepository and all its methods
-keep interface com.domain.repository.IMovieRepository { *; }

# If you have other related domain model classes, add them here
-keep class com.domain.** { *; }

# To ensure that R8 keeps any classes that might be referenced via reflection
-keepattributes Signature, RuntimeVisibleAnnotations


-keep class com.example.removies.** { *; }