import { defineConfig } from 'astro/config';
import starlight from '@astrojs/starlight';

export default defineConfig({
  site: 'https://aldefy.github.io',
  base: '/compose-pinch-grid',
  integrations: [
    starlight({
      title: 'PinchGrid',
      description: 'Google Photos-style pinch-to-resize grid for Compose Multiplatform',
      social: {
        github: 'https://github.com/aldefy/compose-pinch-grid',
        'x.com': 'https://x.com/AditLal',
      },
      customCss: ['./src/styles/custom.css'],
      sidebar: [
        {
          label: 'Getting Started',
          items: [
            { label: 'Installation', link: '/getting-started/installation/' },
            { label: 'Quick Start', link: '/getting-started/quick-start/' },
          ],
        },
        {
          label: 'Guide',
          items: [
            { label: 'Gesture Configuration', link: '/guide/gesture-config/' },
            { label: 'Transitions', link: '/guide/transitions/' },
            { label: 'Breathing Scale', link: '/guide/breathing-scale/' },
            { label: 'Haptic Feedback', link: '/guide/haptic-feedback/' },
            { label: 'Programmatic Control', link: '/guide/programmatic-control/' },
          ],
        },
        {
          label: 'API Reference',
          items: [
            { label: 'PinchGrid', link: '/api/pinch-grid/' },
            { label: 'PinchGridState', link: '/api/pinch-grid-state/' },
            { label: 'PinchGridDefaults', link: '/api/pinch-grid-defaults/' },
          ],
        },
      ],
    }),
  ],
});
